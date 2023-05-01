mongo = new Mongo("localhost");
db = mongo.getDB("admin");
db.createUser(
   {
       user: "test",
       pwd: "test",
       roles: [
           {
               role: "dbAdmin",
               db: "todo"
           },
           {
               role: "readWrite",
               db: "todo"
           },
           {
               role: "dbAdmin",
               db: "todo-test"
           },
           {
               role: "readWrite",
               db: "todo-test"
           }
       ]
   }
);