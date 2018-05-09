package com.example.syl.travel.ui;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.syl.travel.R;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.kakao.auth.AuthType;
import com.kakao.auth.ISessionCallback;
import com.kakao.auth.Session;
import com.kakao.network.ErrorResult;
import com.kakao.usermgmt.UserManagement;
import com.kakao.usermgmt.callback.MeResponseCallback;
import com.kakao.usermgmt.response.model.UserProfile;
import com.kakao.util.exception.KakaoException;

import org.json.JSONObject;

import java.util.Arrays;


public class LoginActivity extends AppCompatActivity {


    static Context mContext;
    private CallbackManager faceCallbackManager;
    SessionCallback kakaoCallback;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login1);

        mContext = getApplicationContext();
        kakaoCallback = new SessionCallback();
        Session.getCurrentSession().addCallback(kakaoCallback);





        /********************************email Login*************************************/
        Button emailLoginButton = (Button) findViewById(R.id.emailLoginButton);
        emailLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent login2Intent = new Intent(LoginActivity.this, Login2Activity.class);
                LoginActivity.this.startActivity(login2Intent);
            }
        });

        /****************************FaceBook Login***********************************/
        Button facebookLoginButton = (Button) findViewById(R.id.fbLoginButton);
        facebookLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                facebookLoginOnClick(view);
            }
        });

        /******************************Kakaotalk Login*********************************/

        Button kakaoLoginButton = (Button) findViewById(R.id.kkLoginButton);
        kakaoLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Session session = Session.getCurrentSession();
                session.addCallback(new SessionCallback());
                session.open(AuthType.KAKAO_LOGIN_ALL, LoginActivity.this);

            }
        });


        /****************************Register Button************************************/
        TextView registerButton = (TextView) findViewById(R.id.registerButton);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registerIntent = new Intent(LoginActivity.this, RegisterActivity.class);
                LoginActivity.this.startActivity(registerIntent);
            }
        });


    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        faceCallbackManager.onActivityResult(requestCode, resultCode, data);
    }

    /***************************************FaceBook Function **********************************/
    public void facebookLoginOnClick(View v){
        FacebookSdk.sdkInitialize(getApplicationContext());
        faceCallbackManager = CallbackManager.Factory.create();

        LoginManager.getInstance().logInWithReadPermissions(LoginActivity.this,
                Arrays.asList("public_profile", "email"));
        LoginManager.getInstance().registerCallback(faceCallbackManager, new FacebookCallback<LoginResult>() {

            @Override
            public void onSuccess(final LoginResult result) {

                GraphRequest request;
                request = GraphRequest.newMeRequest(result.getAccessToken(), new GraphRequest.GraphJSONObjectCallback() {

                    @Override
                    public void onCompleted(JSONObject user, GraphResponse response) {
                        if (response.getError() != null) {

                        } else { //tocken 가져옴
                            Log.i("TAG", "user: " + user.toString());
                            Log.i("TAG", "AccessToken: " + result.getAccessToken().getToken());
                            setResult(RESULT_OK);

                            //페이프북 로그인이 완료 되면 메인페이지로 이동
                            Intent facebookIntent = new Intent(LoginActivity.this, MainActivity.class);
                            startActivity(facebookIntent);
                            finish();
                        }
                    }
                });
                Bundle parameters = new Bundle();
                parameters.putString("fields", "id,name,email,gender,birthday");
                request.setParameters(parameters);
                request.executeAsync();
            }

            @Override
            public void onError(FacebookException error) {
                Log.e("test", "Error: " + error);
                finish();
            }

            @Override
            public void onCancel() {
                finish();
            }
        });
    }


    /***************************************Kakao Session **********************************/

    public class SessionCallback implements ISessionCallback {



        // 로그인에 성공한 상태

        @Override

        public void onSessionOpened() {

            requestMe();

        }



        // 로그인에 실패한 상태

        @Override

        public void onSessionOpenFailed(KakaoException exception) {
            System.out.println("확인용===============================================로그인 실패..=============");
            Log.e("SessionCallback :: ", "onSessionOpenFailed : " + exception.getMessage());

        }



        // 사용자 정보 요청

        public void requestMe() {

            // 사용자정보 요청 결과에 대한 Callback

            UserManagement.getInstance().requestMe(new MeResponseCallback() {

                // 세션 오픈 실패. 세션이 삭제된 경우,

                @Override

                public void onSessionClosed(ErrorResult errorResult) {
                    System.out.println("확인용===============================================onSessionClosed 메서드지남");
                    Log.e("SessionCallback :: ", "onSessionClosed : " + errorResult.getErrorMessage());

                }



                // 회원이 아닌 경우,

                @Override

                public void onNotSignedUp() {

                    Log.e("SessionCallback :: ", "onNotSignedUp");

                }



                // 사용자정보 요청에 성공한 경우,

                @Override

                public void onSuccess(UserProfile userProfile) {



                    Log.e("SessionCallback :: ", "onSuccess");



                    String nickname = userProfile.getNickname();

                    String email = userProfile.getEmail();

                    String profileImagePath = userProfile.getProfileImagePath();

                    String thumnailPath = userProfile.getThumbnailImagePath();

                    String UUID = userProfile.getUUID();

                    long id = userProfile.getId();



                    Log.e("Profile : ", nickname + "");

                    Log.e("Profile : ", email + "");

                    Log.e("Profile : ", profileImagePath  + "");

                    Log.e("Profile : ", thumnailPath + "");

                    Log.e("Profile : ", UUID + "");

                    Log.e("Profile : ", id + "");
                    System.out.println("확인용===============================================o성공!!!!!!!!!!!!!!!");

                    Intent kakaoIntent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(kakaoIntent);
                    finish();
                }



                // 사용자 정보 요청 실패

                @Override

                public void onFailure(ErrorResult errorResult) {

                    Log.e("SessionCallback :: ", "onFailure : " + errorResult.getErrorMessage());

                }

            });

        }

    }


}




