# democlient
Flux working with futures and MYSQL


MYSQL as we know is uses JDBC, and is a blocking thread.

In this example I am using mysql, and publishing the results using completableFuture and Flux.

Of course it still remains a blocking thread, but now at least wait for results is completely streamed and built in a reactive way.
