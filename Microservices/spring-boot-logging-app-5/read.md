Loggs will be added 2 times (root log appender and the class level appender both writing to the log)
<logger name="com.example.demo" additivity="false" level="DEBUG">
  <appender-ref ref="CONSOLE" />
</logger>

or just use
<logger name="com.example.demo" level="debug"/>