import './styles.css';

import { Evaluation } from 'types/evaluation';
import { ReactComponent as StarImage } from "assets/images/star-image.svg";


type Props = {
    evaluations: Evaluation[];
}

const EvaluationCard = ( { evaluations } : Props) => {

   return (
     <div className="card-evaluation-list">
       {evaluations?.map((e) => (
         <div key={e.id}>
         <div className="card-evaluation-name">
           <StarImage className="card-star-image"></StarImage>
           <h6>{e.user.name}</h6>
         </div>
         <div className="card-evaluation-message">
           <h6>{e.text}</h6>
         </div>
         </div>
      ))}
     </div>
   )
}

export default EvaluationCard;