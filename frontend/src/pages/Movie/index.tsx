import { useParams } from 'react-router-dom';
import { useEffect, useState } from 'react';
import { hasAnyRoles } from 'util/auth';
import { Evaluation } from 'types/evaluation';
import { AxiosRequestConfig } from 'axios';
import { requestBackend } from 'util/requests';

import './styles.css';
import EvaluationCard from 'components/EvaluationCard';
import EvaluationForm from 'components/EvaluationForm';

type UrlParams = {
  movieId: string;
};
 
const Movie = () => {
  const {movieId} = useParams<UrlParams>();

  const [evaluations, setEvaluations] = useState<Evaluation[]>([]);

  const handleInsertEvaluation = (evaluation: Evaluation)=>{
    const clone = [...evaluations]
    clone.push(evaluation)
    setEvaluations(clone)
  }


  useEffect(() => {
    const params: AxiosRequestConfig = {
      method: 'GET',
      url: `/movies/${movieId}/reviews`,
      withCredentials:true,
    };
 
    requestBackend(params)
      .then((response) => {
        setEvaluations(response.data);
      })
  }, [movieId]);
 
  return (
    <div className="base-card evaluation-card">
      <h1>Tela listagem de filmes id: {movieId}</h1>
      {hasAnyRoles(['ROLE_MEMBER']) && 
       <EvaluationForm movieId={movieId} onInsertEvaluation={handleInsertEvaluation}/>
       }
       <EvaluationCard evaluations={evaluations}/>
    </div>

  );
};

export default Movie;
