<B>This is the start of LinkedIn Project under Anuj Bhaiya of CodingShuttle.<br>
Following things done till now:</B>
<ul>
<ol>
    <B>Posts</B>
<li>Uses Postgres as Database</li>
<li>Made post service for making posts</li>
<li>Added liking and disliking posts feature</li>
<li>Added feature to get all posts from user</li>
</ol><br>
<ol> <B>User</B>
<li>Uses Postgres database</li>
<li>Added authentication service(in crude from)</li>
<li>Added JWT token generation</li>
<li>Provided signup and login feature</li>
</ol><br>
<ol><B>Api-Gateway</B>
<li>Added api gateway which will used to register all <br> services and all requests must go through it to other microservices</li>
<li> In future will act as single point of connection for all microservices</li>
<li>Will handle authentication for all services</li>
</ol><br>
<ol> <B>Discovery Server</B>
<li> Added Netflix's Eureka Server so that all services can find each other</li>
</ol><br>
<ol><B>Connection Service</B>
<li>Added support for users to connect with each other <br>
(not much feature ,hardcoded implementation , will change in future)</li>
<li>Uses neo4j  as a database to store connections between users</li>
</ol>
</ul>