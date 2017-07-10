#   Collection

##  queue
### 操作方法
|方法| 作用| 说明|
| --- | ---- | ---- |
|add|增加一个元素| 如果队列已满，则抛出一个ILLegalException异常|
|remove  |  移除并返回队列头部的元素     |   如果队列为空，则抛出一个NoSuchElementException异常|
|element |  返回队列头部的元素        |     如果队列为空，则抛出一个NoSuchElementException异常|
|offer   |     添加一个元素并返回true |      如果队列已满，则返回false|
|poll    |      移除并返问队列头部的元素 |   如果队列为空，则返回null|
|peek    |    返回队列头部的元素      |       如果队列为空，则返回null|
|put     |     添加一个元素        |              如果队列满，则阻塞|
|take    |     移除并返回队列头部的元素  |   如果队列为空，则阻塞|

### 实现类
*   ArrayBlockingQueue ：一个由数组结构组成的有界阻塞队列。
*   LinkedBlockingQueue ：一个由链表结构组成的有界阻塞队列。
*   PriorityBlockingQueue ：一个支持优先级排序的无界阻塞队列。
*   DelayQueue：一个使用优先级队列实现的无界阻塞队列。
*   SynchronousQueue：一个不存储元素的阻塞队列。
*   LinkedTransferQueue：一个由链表结构组成的无界阻塞队列。
*   LinkedBlockingDeque：一个由链表结构组成的双向阻塞队列。

1.  ArrayBlockingQueue(不会自动扩容,取和放共用一把锁,无法同时操作)
>   在构造时需要指定容量， 并可以选择是否需要公平性，如果公平参数被设置true，
    等待时间最长的线程会优先得到处理（其实就是通过将ReentrantLock设置为true来达到这种公平性的：
    即等待时间最长的线程会先操作）。通常，公平性会使你在性能上付出代价，只有在的确非常需要的时候再使用它。
    它是基于数组的阻塞循环队 列，此队列按 FIFO（先进先出）原则对元素进行排序。
2.  LinkedBlockingQueue(取和放共用两把锁,可以同时操作)
>   如果构造时不指定容量,则默认为Integer.max,如果生产的速度一直大于消费的速度,则有可能造成在阻塞之前资源就被耗尽   

2.  PriorityBlockingQueue
>   一个带优先级的 队列，而不是先进先出队列。
    元素按优先级顺序被移除，该队列也没有上限（PriorityBlockingQueue是对 PriorityQueue的再次包装，是基于堆数据结构的，而PriorityQueue是没有容量限制的，与ArrayList一样，
    所以在优先阻塞 队列上put时是不会受阻的。虽然此队列逻辑上是无界的，但是由于资源被耗尽，所以试图执行添加操作可能会导致 OutOfMemoryError），
    但是如果队列为空，那么取元素的操作take就会阻塞，所以它的检索操作take是受阻的。另外，往入该队列中的元 素要具有比较能力。

3.  DelayQueue
>   基于PriorityQueue来实现的）是一个存放Delayed 元素的无界阻塞队列，
    只有在延迟期满时才能从中提取元素。该队列的头部是延迟期满后保存时间最长的 Delayed 元素。
    如果延迟都还没有期满，则队列没有头部，并且poll将返回null。
    当一个元素的 getDelay(TimeUnit.NANOSECONDS) 方法返回一个小于或等于零的值时，则出现期满，poll就以移除这个元素了。
    此队列不允许使用 null 元素。
     
4.  SynchronousQueue
>   特殊的BlockingQueue,对其的操作必须是放和取交替完成的.