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

<h2>Operation api</h2>

Recommendations controller:

</br>/popularity           type: GET -- Provide city name, return a list of popularity movies
</br>/release_date         type: GET -- Provide city name, return a list of release date movies
</br>/vote_average         type: GET -- Provide city name, return a list of vote average movies

<h2>Desafio</h2>
</br>Eu gostaria de sugestões de filmes em cartaz baseado em meu ânimo.
</br>Meu ânimo varia conforme a temperatura atual de onde estou. Sendo que se:
</br>A temperatura está acima de 40 graus, nesse caso eu gosto de ver filmes de ação.
</br>A temperatura está entre 36 e 40 graus, está bem quente e eu prefiro ver filmes de comédia.
</br>A temperatura está entre 20 e 35 graus, está agradável e assim eu prefiro ver animações.
</br>A temperatura está entre 0 e 20 graus, está frio e eu gostaria de ver filmes de suspense.
</br>A temperatura está abaixo de 0 grau, está um frio glacial e, nesse caso, a melhor opção seriam documentários.
</br>Quero uma API RESTful (Java) que me dê essas sugestões de filmes e um guia de como utilizar essa API (Readme.md).
