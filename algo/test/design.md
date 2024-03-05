# F

Deisgn Pockemon Go with following api:
```
* add / remove pockemon from map (every pockemon full life cycle on map - 20 min, every 20m it dies, supported 500M of pockemons on global map
* query pockemon s around current user location (500M Daily active users)
```

# A

## S3 Storage

Create Object Storage (S3) System should be distributed, scalable.

* replica management, how replication should be built, what risk factors? 
* replicateion model with with n replicas and lower than n replication factor?
(E.g. replica x y is on DC1, replica z: x+y=z on DC2, replicas x y on DC3, replicatoion factor 
is x+y+z+x+y / x+y = 5/2 = 2.5 in this case)
* Will the system function properly on one DC cutoff? Two DC cutoffs? how would you fix it?
* How to buld a object storage to sustain 100 PB storage size, with avg customer storage size 2 GB.
API usage per customer: 80% get object, 15% put object, 5% delete object, 100K RPS

## S3 Storage (Low Level)

Create Object Storage System (e.g. AWS S3)
low level questions: 
* how we should optimize data storage (e.g. union small files in chunks for sequential reads from HDD, 
split large files - what cutoff point should be used - how its identified? multipart files?)
* HDD vs SSD vs memory: how decision should be made? Walk me thru your analysis
* Why we need Metadata nodes in object storage? metadata nodes replication? Can we build metdata from ground up if all metdata servers are gone? Disaster recovery?
* Metadata ears dropping for raft protocol b/w replicas, hints for storage node leader in metdata data set. Examples of possible optimizations?
* Encription at rest, encryption at client
* Compression for in network access b/w application nodes and storage nodes

## Key Value

Create Ke Value Distributed / Scalable Storage System with strong cosistency + eventual consistency options available
* couple of questions about gossiping protocol, raft etc.
* What happens when 1 out of 3 replicas is gone : split brain situation (3 replicas, one replica 
    is down, 2 are available, the data is in a process of copy to a new replica created instead of failed one - 
    2 nodes are actually in working state - will this trigger split brain?) 
* hoow many storage nodes should we have if there are many replicas. 
* couple questions about replication log and database itself (b tree). Should replication log be persistend on disk? Why do we need replication log?
what happens if storage node is down?
* strong consistency, eventual consistency
* leader / follower election - can data be read from non leader nodes? why do we need followers at all? 3 replicas consistent write writes to LEADer + 1 Follower and 
returns back to the customer with success. Is it consistent write, what mechanism in protocol will ensure its consistent write?

## Transaction Service

Create Transaction Service - Distributed & Scalable Service that supports the following API (service should be consistent and scalable)
```
* lock (file, range_start..range_end)
* unlock (file, range_start..range_end)
```
CAP theorem - how it applies here?
Replication for databases?
Support for transactions? Distributed transactions
How to allow infinite (>1 TB of lock record size, per the same file)? Distributed transactions?
Blocking vs Error to customer when lock cannot be executed

