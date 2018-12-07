FROM maven:3-jdk-8-alpine as builder

ARG LOCAL_MAVEN_MIRROR=http://maven.aliyun.com/nexus/content/groups/public/

# used to edit maven settings.xml
RUN apk add --no-cache xmlstarlet

# change default local repository location. parent image set ~/.m2 as volume, so data won't be persisted for following build cmds
RUN xmlstarlet ed --inplace -N 's=http://maven.apache.org/SETTINGS/1.0.0' \
	--subnode '/s:settings' --type elem -n localRepository -v '${user.home}/m2/repository' \
	/usr/share/maven/conf/settings.xml

RUN if test -n "$LOCAL_MAVEN_MIRROR"; then \
	xmlstarlet ed --inplace -N 's=http://maven.apache.org/SETTINGS/1.0.0' \
		--subnode '/s:settings/s:mirrors' --type elem -n mirror -v '' \
		/usr/share/maven/conf/settings.xml \
	&& xmlstarlet ed --inplace -N 's=http://maven.apache.org/SETTINGS/1.0.0' \
		--subnode '/s:settings/s:mirrors/s:mirror' --type elem -n id -v 'custom-mirror' \
		/usr/share/maven/conf/settings.xml \
	&& xmlstarlet ed --inplace -N 's=http://maven.apache.org/SETTINGS/1.0.0' \
		--subnode '/s:settings/s:mirrors/s:mirror' --type elem -n name -v 'custom-mirror' \
		/usr/share/maven/conf/settings.xml \
	&& xmlstarlet ed --inplace -N 's=http://maven.apache.org/SETTINGS/1.0.0' \
		--subnode '/s:settings/s:mirrors/s:mirror' --type elem -n url -v "$LOCAL_MAVEN_MIRROR" \
		/usr/share/maven/conf/settings.xml \
	&& xmlstarlet ed --inplace -N 's=http://maven.apache.org/SETTINGS/1.0.0' \
		--subnode '/s:settings/s:mirrors/s:mirror' --type elem -n mirrorOf -v 'central' \
		/usr/share/maven/conf/settings.xml \
	;fi


# if pom.xml is not updates, m2/ may be cached as well
COPY pom.xml /JAVAProject/pom.xml
RUN cd /JAVAProject \
	&& mvn dependency:resolve

# copy src/ and build, src changes constantly
COPY ./src /JAVAProject/src

RUN cd /JAVAProject \
	&& find /JAVAProject/src -type f -exec chmod 640 {} \; \
	&& mvn -DskipTests=true package


# ------------------------- 8< -------------------------

FROM tomcat:9

RUN rm -r /usr/local/tomcat/webapps

COPY --from=builder /JAVAProject/target/*.war /usr/local/tomcat/webapps/ROOT.war

EXPOSE 8080
