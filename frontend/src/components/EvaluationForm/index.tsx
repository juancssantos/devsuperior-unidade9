import { AxiosRequestConfig } from 'axios';
import { useForm } from 'react-hook-form';
import { Evaluation } from 'types/evaluation';
import { requestBackend } from 'util/requests';
import './styles.css';
 


type Props = {
    movieId: string;
    onInsertEvaluation: (evaluation: Evaluation) => void
}

type FormData = {
    movieId: number;
    text: string;
}

const EvaluationForm = ( { movieId ,onInsertEvaluation} : Props) => {

    const {
        register, 
        handleSubmit,
        formState: {errors},
        setValue
    } = useForm<FormData>();

    const onSubmit = (formData: FormData)=>{

        formData.movieId = parseInt(movieId);

    const config: AxiosRequestConfig = {
        method: 'POST',
        url: '/reviews',
        data: formData,
        withCredentials: true,
    };

    requestBackend(config)
    .then (response => {
        setValue('text',"")
        onInsertEvaluation(response.data)
        
    })
    .catch(error=> {
        console.log("ERRO AO SALVAR",error);
    })
}

   return (
     <>
      <form className="form-control form-control-evaluation" onSubmit={handleSubmit(onSubmit)}>
      <div className="card-evaluation">
       <input
           {...register('text', {
            required: 'Campo obrigatório'
          })}
          type="text"
          className={`form-control base-input ${errors.text ? 'is-invalid' : ''}`}
          placeholder='Deixe sua avaliação aqui' 
          name='text'></input>
          <div className="invalid-feedback d-block">{errors.text?.message}</div>
       <button className='btn btn-primary btn-salvar'>Salvar Avaliação</button>
      </div>
      </form>
     </>
   )
}

export default EvaluationForm;