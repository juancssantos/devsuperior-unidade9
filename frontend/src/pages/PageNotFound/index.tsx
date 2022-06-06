import './styles.css';
import { Link } from 'react-router-dom';


const PageNotFound = () => { 
  return (
       <div className="not-found-card">
       <h1>Página Não Encontrada</h1>
       <Link to="/movies"><h3>Voltar</h3></Link>
       </div>
    
  );
}

export default PageNotFound;
