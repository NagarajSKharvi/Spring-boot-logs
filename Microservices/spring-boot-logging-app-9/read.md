Time to use both Console and Rolling File Appenders

Run the application ->
app.log file gets created and when the file size reaches to 1MB as specified in maxFileSize tag, log file named app.log gets changed to app_2.app
and new log file app.log gets created.
This continues till there will be 5 max files in logs directory. After that old file gets deleted and it follows the rolling policy.

<property name="LOG_FILE" value="logs/app" />
	<appender name="ROLLING_FILE" class="ch.qos.logback.core.rolling.RollingFileAppender">
		<file>${LOG_FILE}.log</file>
		<encoder class="ch.qos.logback.classic.encoder.PatternLayoutEncoder">
			<pattern>[%d{dd-MM-yyyy HH:mm:ss.SSS}][%X{traceId}/%X{spanId}]%magenta([%thread]) %highlight(%-5level) %cyan(%logger{100}.%M)->%msg %n
			</pattern>
		</encoder>
		<rollingPolicy class="ch.qos.logback.core.rolling.FixedWindowRollingPolicy">
		    <fileNamePattern>
		      ${LOG_FILE}_%i.log
		    </fileNamePattern>
		    <minIndex>2</minIndex>
		    <maxIndex>5</maxIndex>
	 	</rollingPolicy>
	    <triggeringPolicy class="ch.qos.logback.core.rolling.SizeBasedTriggeringPolicy">
	    	<maxFileSize>1MB</maxFileSize>
	    </triggeringPolicy>
	</appender>


Controller to differentiate between logs
@GetMapping("/rest")
	public String getMessage() {
		for (int i = 0; i < 250; i++) {
			log.info(logPrefix, this.getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getMethodName());
			log.debug(logPrefix, this.getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getMethodName());
			log.warn(logPrefix, this.getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getMethodName());
			log.error(logPrefix, this.getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getMethodName());
		}
		return "Rest Call working";
	}
	/*
	*/ 
	@GetMapping("/errors")
	public String getErrors() {
		for (int i = 0; i < 250; i++) {
			log.error(logPrefix, this.getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getMethodName());
			log.error(logPrefix, this.getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getMethodName());
			log.error(logPrefix, this.getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getMethodName());
			log.error(logPrefix, this.getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getMethodName());
		}
		return "Rest Call working";
	}
	
	
	