1. FEATURE EXPECTATIONS [5 min]
	1. Use cases
  1. Scenarios that will not be covered
  1. Who will use
  1. How many will use
  1. Usage patterns
1. STIMATIONS [5 min]
  1. hroughput (QPS for read and write queries)
  1. atency expected from the system (for read and write queries)
  1. Read/Write ratio
  1.Traffic estimates
  	* Write (QPS, Volume of data)
    * Read  (QPS, Volume of data)
  1. Storage estimates
  1. Memory estimates
  	* If we are using a cache, what is the kind of data we want to store in cache
    * How much RAM and how many machines do we need for us to achieve this ?
    * Amount of data you want to store in disk/ssd
1. DESIGN GOALS [5 min]
  	* Latency and Throughput requirements
    * Consistency vs Availability  [Weak/strong/eventual => consistency | Failover/replication => availability]
1. HIGH LEVEL DESIGN [5-10 min]
	1. APIs for Read/Write scenarios for crucial components
  1. Database schema
  1. Basic algorithm
  1. High level design for Read/Write scenario
1. DEEP DIVE [15-20 min]
	1. Scaling the algorithm
  1. Scaling individual components: 
 		* -> Availability, Consistency and Scale story for each component
    * -> Consistency and availability patterns
  1. Think about the following components, how they would fit in and how it would help
  	1. DNS
    1. CDN [Push vs Pull]
    1. Load Balancers [Active-Passive, Active-Active, Layer 4, Layer 7]
    1. Reverse Proxy
    1. Application layer scaling [Microservices, Service Discovery]
    1. DB [RDBMS, NoSQL]
    	* RDBMS 
      	* Master-slave, Master-master, Federation, Sharding, Denormalization, SQL Tuning
      * NoSQL
      	* Key-Value, Wide-Column, Graph, Document
        * Fast-lookups:
					* RAM  [Bounded size] => Redis, Memcached
          * AP [Unbounded size] => Cassandra, RIAK, Voldemort
          * CP [Unbounded size] => HBase, MongoDB, Couchbase, DynamoDB
    1. caches
    	* client caching, CDN caching, Webserver caching, Database caching, Application caching, Cache @Query level, Cache @Object level
      * Eviction policies:
                                >> Cache aside
                                >> Write through
                                >> Write behind
                                >> Refresh ahead
      * Asynchronism
                        > Message queues
                        > Task queues
                        > Back pressure
      * Communication
                        > TCP
                        > UDP
                        > REST
                        > RPC
1. JUSTIFY [5 min]
	1. Throughput of each layer
	1. Latency caused between each layer
	(3) Overall latency justification
