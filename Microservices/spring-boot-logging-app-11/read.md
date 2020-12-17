To make your logging framework support Spring profile you have to rename your file from logback.xml to logback-spring.xml

<?xml version="1.0" encoding="UTF-8"?>
<configuration>
	<include resource="/org/springframework/boot/logging/logback/base.xml"/>
	<!-- <logger name="org.springframework.web" level="DEBUG"/> -->
	<logger name="org.springframework.jdbc.core.JdbcTemplate">
		<level value="debug" />
	</logger>
	<logger
		name="org.springframework.jdbc.core.StatementCreatorUtils">
		<level value="debug" />
	</logger>
	<logger name="org.springframework" level="WARN" />
	<logger name="org.springframework.transaction" level="WARN" />
	<!-- <property name="FILE_LOG" value="${LOG_FILE}"/> -->
	<appender name="CONSOLE"
		class="ch.qos.logback.core.ConsoleAppender">
		<!-- On Windows machines setting withJansi to true enables ANSI color code 
			interpretation by the Jansi library. This requires org.fusesource.jansi:jansi:1.8 
			on the class path. Note that Unix-based operating systems such as Linux and 
			Mac OS X support ANSI color codes by default. -->
		<withJansi>true</withJansi>
		<layout class="ch.qos.logback.classic.PatternLayout">
			<pattern>[%d{dd-MM-yyyy HH:mm:ss.SSS}][%X{traceId}/%X{spanId}]%magenta([%thread]) %highlight(%-5level) %cyan(%logger{100}.%M)->%msg %n
			</pattern>
		</layout>
	</appender>
	<property name="LOG_FILE" value="logs/icms" />
	<!-- Rolling policy -->
	<appender name="ROLLINGFILE"
		class="ch.qos.logback.core.rolling.RollingFileAppender">
		<file>${LOG_FILE}.log</file>
		<encoder
			class="ch.qos.logback.classic.encoder.PatternLayoutEncoder">
			<pattern>[%d{dd-MM-yyyy HH:mm:ss.SSS}][%X{traceId}/%X{spanId}]%magenta([%thread]) %highlight(%-5level) %cyan(%logger{100}.%M)->%msg %n
			</pattern>
		</encoder>
		<rollingPolicy
			class="ch.qos.logback.core.rolling.TimeBasedRollingPolicy">
			<!-- rollover daily and when the file reaches 10 MegaBytes -->
			<fileNamePattern>${LOG_FILE}.%d{yyyy-MM-dd}.%i.gz</fileNamePattern>
			<maxHistory>10</maxHistory>
			<totalSizeCap>1GB</totalSizeCap>
			<timeBasedFileNamingAndTriggeringPolicy
				class="ch.qos.logback.core.rolling.SizeAndTimeBasedFNATP">
				<maxFileSize>100MB</maxFileSize>
			</timeBasedFileNamingAndTriggeringPolicy>
		</rollingPolicy>
	</appender>
	<root level="INFO">
		<appender-ref ref="ROLLINGFILE" />
		<appender-ref ref="CONSOLE" />
		<!-- <appender-ref ref="STDOUT" /> -->
	</root>
	<springProfile name="DEV">
        <logger name="com.enkindle" level="info"/>
    </springProfile>
    <springProfile name="UDEV">
        <logger name="com.enkindle" level="info"/>
    </springProfile>
    <springProfile name="PRO">
        <logger name="com.enkindle" level="info"/>
    </springProfile>
    <springProfile name="QA">
        <logger name="com.enkindle" level="info"/>
    </springProfile>
</configuration>