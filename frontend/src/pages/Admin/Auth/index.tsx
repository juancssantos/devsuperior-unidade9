import { ReactComponent as AuthImage } from "assets/images/auth-image.svg";
import Login from "./Login";

import "./styles.css";

const Auth = () => {
  return (
    <div className="auth-container">
      <div className="auth-banner-container">
        <div>
          <h1>Avalie Filmes</h1>
          <p>Diga o que você achou do seu filme favorito</p>
        </div>
        <AuthImage />
      </div>
      <div className="auth-form-container">
        <Login />
      </div>
    </div>
  );
};

export default Auth;
