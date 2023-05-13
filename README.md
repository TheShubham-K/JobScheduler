## Job Scheduler 

- used shedlock-spring library
- for more enterprise class features use Quartz

## Distributed Job Scheduler Quartz
Quartz Scheduler is an open-source distributed job scheduler that provides many enterprise-class features like support for JTA transactions and clustering.

Among its main capabilities is job persistence support to an external database that is very useful for resuming failed jobs as well as for reporting purposes.

Clustering is another key feature of Quartz that can be used for Fail-safe and/or Load Balancing.

Spring Scheduler is preferred when we want to implement a simple form of job scheduling like executing methods on a bean every X seconds, or on a cron schedule without worrying about any side effects of restarting jobs after failures.

On the other hand, if we need clustering along with support for job persistence then Quartz is a better alternative.


## Points to keep in mind before designing cron Scheduler

- Scheduling is part of the core module, so we do not need to add any dependencies.
- Scheduling is not enabled by default. We explicitly enable scheduling by adding the @EnableScheduling annotation to a Spring configuration class.
- We can make the scheduling conditional on a property so that we can enable and disable scheduling by setting the property.
- We create scheduled jobs by decorating a method with the @Scheduled annotation.
- Only methods with void return type and zero parameters can be converted into scheduled jobs by adding @Scheduled annotation.
- We set the interval of executing by specifying the fixedRate or fixedDelay attribute in the @Scheduled annotation.
- We can choose to delay the first execution of the method by specifying the interval using the initialDelay attribute.
- We can deploy multiple Scheduler Instances using the ShedLock library which ensures only one instance to run at a time by using a locking mechanism in a shared database.
- We can use a Distributed Job Scheduler like Quartz to address more complex scenarios of scheduling like resuming failed jobs, and reporting. 