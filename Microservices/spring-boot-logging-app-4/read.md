<root level="DEBUG">
    <appender-ref ref="CONSOLE"/>
</root>
 
<logger name="com.example.demo" level="DEBUG">
	<appender-ref ref="CONSOLE" />
</logger>

Loggs will be added 2 times (root log appender and the class level appender both writing to the log)