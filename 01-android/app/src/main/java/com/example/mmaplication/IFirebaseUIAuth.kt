package com.example.mmaplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.VISIBLE
import android.widget.Button
import androidx.activity.result.registerForActivityResult
import com.example.cspnapplication.R
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.FirebaseAuthUIActivityResultContract
import com.firebase.ui.auth.IdpResponse
import com.firebase.ui.auth.data.model.FirebaseAuthUIAuthenticationResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.core.View

class IFirebaseUIAuth : AppCompatActivity() {
    private val signInLaucher = registerForActivityResult(
        FirebaseAuthUIActivityResultContract()
    ){res: FirebaseAuthUIAuthenticationResult ->
        if(res.resultCode === RESULT_OK){
            if(res.idpResponse != null){
                seLogeo(res.idpResponse!!)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ifirebase_uiauth)

        val btnLogin = findViewById<Button>(R.id.btn_login_firebase)
        btnLogin.setOnClickListener{
            val providers = arrayListOf(
                AuthUI.IdpConfig.EmailBuilder().build()
            )
            //cREATE AND LAUCH SING-IN INTENT
            val signInIntent = AuthUI.getInstance()
                .createSignInIntentBuilder()
                .setAvailableProviders(providers)
                .build()
            signInLaucher.launch(signInIntent)
        }
        val btnLogout = findViewById<Button>(R.id.btn_logout_firebase)
        btnLogout.setOnClickListener{seDeslogeo()}
    }
    fun seLogeo(
        res: IdpResponse
    ){
        val btnLogin = findViewById<Button>(R.id.btn_login_firebase)
        val btnLogout = findViewById<Button>(R.id.btn_logout_firebase)
        btnLogout.visibility = View.VISIBLE
        btnLogin.visibility = View.INVISIBLE
        if(res.isNewUser == true){
            registrarUsuarioPorPrimeraVez(res)
        }
    }
    fun registrarUsuarioPorPrimeraVez(
        usuario: IdpResponse
    ){
        //Firestore
    }

    fun seDeslogeo(){
        val btnLogin =findViewById<Button>(R.id.btn_login_firebase)
        val btnLogout = findViewById<Button>(R.id.btn_logout_firebase)
        btnLogin.visibility = View.VISIBLE
        btnLogout.visibility = View.INVISIBLE
        FirebaseAuth.getInstance().signOut()
    }

}