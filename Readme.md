# Project Recommendations Movie
<h2>Instructions for uses</h2>

You can directly access:
https://apimovierecommendations.herokuapp.com/swagger-ui.html
----------------------------------------------------------------

<h2>Run on your machine</h2>

You need install docker in your machine.

Access the terminal and execute to a download image docker:
</br>docker pull jeferson267/api_recommendations_movie

After finished download, execute to create docker a container:
</br>*Change {yourPort} to a free door Example:8083
</br>*docker run -d --name container_recommendations_movie -p {yourPort}:8080 jeferson267/api_recommendations_movie

Use the link for access project:
</br>*Change {yourPort} to a free door Example:8083
</br>*http://localhost:{yourPort}/swagger-ui.html#
</br>Example: http://localhost:8083/swagger-ui.html#

You can stop container using:
</br>docker stop container_recommendations_movie

You can access project again, execute to start a container:
</br>docker start container_recommendations_movie

----------------------------------------------------------------

**Operation api:

Recommendations controller:

</br>/popularity           GET -- Provide city name, return a list of popularity movies
</br>/release_date         GET -- Provide city name, return a list of release date movies
</br>/vote_average         GET -- Provide city name, return a list of vote average movies
