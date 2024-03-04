#### 1/24/2024
Google Interview Screening:
```
// hello
//   # Motivation
//   
//    We'd like to develop a utility to merge two sets of configurations represented as document trees. For example, we could use this
//  utility to merge a global configuration with a user-specific configuration containing some overrides.
//   
//   # Task
//   
//   Design and implement the following method to merge two document trees t1 and t2, according to the merging rules specified below.
//   
//   /** Merges the given document trees. */
//   static merge(Node t1, Node t2) {
//     // TODO: Return a merged Node
//   }

//   Document trees consist of nodes represented by the Node class defined below. Trees can be arbitrarily deep and each node can have 
//  arbitrarily many child nodes. Child nodes are order sensitive, and there can be duplicate child nodes with identical properties.
//   
//   /**
//    * Represents a node in a document tree. Assume that this class also provides
//    * reasonable implementations of constructors, builders, getters, setters,
//    * hashCode(), equals(), etc.
//    *
//    * Tip: Treat this class as a deeply-immutable data type to keep things simple.
//    */
//   class Node {
//     constructor(name, value, childNodes[]) {
//        this.name = name;    // Name of this node
//        this.value = value;  // Value associated with this node
//        // Deep copy the child nodes
//        for(...) {
//          this.childNodes.push(...)
//        }
//     }
//   
//     // Builders, getters, setters, hashCode(), equals(), etc.
//   }
//   
//   # Merging Rules
//   
//   Guiding principle: use t1's node ordering, but t2's node values.
//   
//   When node n1 from t1 is merged with node n2 from t2, the following rules are applied to derive the merged node m (see merging example below):
//   
//   1. The merged node m will take the name property of n1 and the value property of n2.
//   2. The k-th child node of n1 with the name X will be matched and merged with the k-th child node of n2 with the same name X.
//   3. The merged node m will contain all the child nodes of n1 in the same order, but they may have different value properties and child nodes depending
//      on whether they have been merged with the child nodes of n2.
//   4. Unmatched child nodes of n1 will be left unchanged in the merged node m.
//   5. Unmatched child nodes of n2 will be added unchanged in the same order in n2 to the merged node m after the child nodes of n1.
//   
//   # Merging Example
// 
//   
//   NOTATION:
//   
//    node_name: node_value ..... comment
//   
//   INPUT: t1
//   
//     ROOT: t1
//       A: alpha
//           C: beta
//           X: phi
//               Z: mu
//       B: gamma
//       A: delta
//       C: epsilon
//       D: theta
//   
//   
//   INPUT: t2
//   
//     ROOT: t2
//       B: lambda
//       C: zeta
//       E: kappa
//           W: eta
//       A: tau
//           Y: pi
//           C: sigma
//       A: omicron
//       B: lambda ........ duplicate node
//   
//   OUTPUT: merge(t1, t2)
//   
//     ROOT: t2 ........... value from t2
//       A: tau ........... value from t2
//           C: sigma ..... value from t2
//           X: phi ....... unmatched node from t1
//               Z: mu .... child node of the unmatched X node from t1
//           Y: pi ........ unmatched node from t2
//       B: lambda ........ value from t2
//       A: omicron ....... value from t2 (second A node from t1 and t2)
//       C: zeta .......... value from t2
//       D: theta ......... unmatched node from t1
//       E: kappa ......... unmatched node from t2
//           W: eta ....... child node of the unmatched E node from t2
//       B: lambda......... unmatched node from t2 (second B node from t2)

// const exNode = { name: 'test', value: 5, childNodes: [{ name: 'test2', value: 7, childNodes: [] }] }

//   INPUT: t2
//   
//     ROOT: t2
//       B: lambda
//       C: zeta
//       E: kappa
//           W: eta
//       A: tau
//           Y: pi
//           C: sigma
//       A: omicron
```
