Spring boot provides default logging configuration and can be used by specifying like this
<include resource="/org/springframework/boot/logging/logback/base.xml"/>

Plus we can customize our logging
For now our custom class loggs are not displayed in the console
To enable that we need to specify logging level in the logback file 