#   Thread
##  线程中断
1.  中断线程最好的，最受推荐的方式是，使用共享变量（shared variable）发出信号，告诉线程必须停止正在运行的任务。线程必须周期性的核查这一变量（尤其在冗余操作期间），然后有秩序地中止任务。
2.  interrupt interrupted isInterrupted 区别
    `http://blog.csdn.net/z69183787/article/details/25076033`
3.  














#Executor
##  使用线程池的意义
1.  缓存线程、进行池化，可实现线程重复利用、避免重复创建和销毁所带来的性能开销。（如楼主理解的）
2.  当线程调度任务出现异常时，会重新创建一个线程替代掉发生异常的线程。
3.  任务执行按照规定的调度规则执行。线程池通过队列形式来接收任务。再通过空闲线程来逐一取出进行任务调度。即线程池可以控制任务调度的执行顺序。
4.  可制定拒绝策略。即任务队列已满时，后来任务的拒绝处理规则。

##  使用new Thread的缺点
1.  功能单一：run方法执行任务是确定的，不能动态处理多任务。
2.  无法重用：由于第1点提到的功能单一的特点。当出现动态任务时，每run方法执行结束后，线程也就结束(线程状态变为TERMINATED，线程状态可查看Thread.State这个类)，结束状态的线程不能再被重新开启使用。只能占着内存。或者等待被销毁。
3.  耗时较多（特定场景下）：在要求重复接收外界的任务，并异步执行一些任务的场景下，需要重复创建线程来执行（因为结束状态的线程不可重用），另外如果旧的线程没被继续引用，会被销毁并回收。此场景下的耗时原因主要线程创建销毁操作过于频繁。
4.  安全性低一些：线程执行过程发生异常时，线程会直接终止，变为结束状态。

##  使用new Thread的场景
1.  线程执行任务内容已确定
2.  线程不需要频繁创建和销毁
3.  线程不需要重用（跟第2点有点类似）

##  创建线程池的方式
1.  newCachedThreadPool
>   创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程
2.  newFixedThreadPool
>   创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待
3.  newScheduledThreadPool
>   创建一个定长线程池，支持定时及周期性任务执行
4.  newSingleThreadExecutor
>   创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行
>   当执行队列中的任务出现unchecked异常时会自动重新启动一个新的线程继续工作

##  submit和execute的区别
1.  接收的参数不一样 submit（）可以接受runnable无返回值和callable有返回值
2.  submit有返回值，而execute没有
3.  submit方便Exception处理

##  shutdown和shutdownNow的区别
1.  shutdown() 方法在终止前允许执行以前提交的任务
2.  shutdownNow() 方法阻止等待任务启动并试图停止当前正在执行的任务。在终止时执行程序没有任务在执行，也没有任务在等待执行，并且无法提交新任务。关闭未使用的 ExecutorService 以允许回收其资源。 

##  runnable和callable的区别

##  其他
###  ThreadExecutor源码分析
>   参考`http://blog.csdn.net/rebirth_love/article/details/51954836`
###  BlockingQueue
>   参考`http://wsmajunfeng.iteye.com/blog/1629354`,`http://www.oschina.net/question/565065_86540`
1.  LinkedBlockingQueue newFixedThreadPool使用
2.  SynchronousQueue    newCachedThreadPool使用
###  ThreadGroup
>   参考`http://blog.csdn.net/a352193394/article/details/39323427`
###  RejectedExecutionHandler
>   参考`http://blog.csdn.net/pfnie/article/details/52755769`
1.  ThreadPoolExecutor.AbortPolicy   
>   默认,处理程序遭到拒绝将抛出运行时RejectedExecutionException;
2.  ThreadPoolExecutor.CallerRunsPolicy 
>   线程调用运行该任务的 execute 本身。此策略提供简单的反馈控制机制，能够减缓新任务的提交速度
3.  ThreadPoolExecutor.DiscardPolicy  
>   不能执行的任务将被删除;
4.  ThreadPoolExecutor.DiscardOldestPolicy  
>   如果执行程序尚未关闭，则位于工作队列头部的任务将被删除，然后重试执行程序（如果再次失败，则重复此过程）。
###  ThreadFactory

### RunnableFuture

### AtomicInteger
>   使用它实现无锁并发 参考`http://blog.csdn.net/q291611265/article/details/47018583`

### ReentrantLock

### 涉及到的设计模式
1.  命令模式
>   Executor.execute(Runnable command)
2.  模板方法
>   AbstractExecutorService
3.  工厂方法
>   Executors

### 执行过程
1.  如果此时线程池中的数量小于corePoolSize，即使线程池中的线程都处于空闲状态，也要创建新的线程来处理被添加的任务。
2.  如果此时线程池中的数量等于 corePoolSize，但是缓冲队列 workQueue未满，那么任务被放入缓冲队列。
3.  如果此时线程池中的数量大于corePoolSize，缓冲队列workQueue满，并且线程池中的数量小于maxPoolSize，建新的线程来处理被添加的任务。
4.  如果此时线程池中的数量大于corePoolSize，缓冲队列workQueue满，并且线程池中的数量等于maxPoolSize，那么通过handler所指定的策略来处理此任务。
    也就是：处理任务的优先级为：核心线程corePoolSize、任务队列workQueue、最大线程 maximumPoolSize，如果三者都满了，使用handler处理被拒绝的任务。
5.  当线程池中的线程数量大于corePoolSize时，如果某线程空闲时间超过keepAliveTime，线程将被终止。这样，线程池可以动态的调整池中的线程数。


##  参考文献
1.  处理 InterruptedException
    `https://www.ibm.com/developerworks/cn/java/j-jtp05236.html`
