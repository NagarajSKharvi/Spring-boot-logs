RollingPolicy for SizeAndTimeBasedRollingPolicy

<rollingPolicy class="ch.qos.logback.core.rolling.SizeAndTimeBasedRollingPolicy">
    <fileNamePattern>
    ${LOG_FILE}_%d{dd-MM-yyyy}_%i.log
    </fileNamePattern>
     <!-- each archived file, size max 1MB -->
    <maxFileSize>1MB</maxFileSize>
    <!-- 3 days to keep -->
    <maxHistory>3</maxHistory>
    <!-- total size of all archive files, if total size > 10MB, it will delete old archived file -->
    <totalSizeCap>10MB</totalSizeCap>
 </rollingPolicy>