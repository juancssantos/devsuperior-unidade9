import './styles.css';

const MoviesList = () => {
  return (
      <div className="base-card list-card">
      <h1>Tela listagem de filmes</h1>
      <div className='list-card-links'>
      <a href='/movies/1'><h6>Acessar /movies/1</h6></a>    
      <a href='/movies/2'><h6>Acessar /movies/2</h6></a>   
      </div> 
      </div>
  );
};
export default MoviesList;
