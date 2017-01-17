package myapplication.com.myplattvok.avtivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import myapplication.com.myplattvok.R;
import myapplication.com.myplattvok.bean.Bean;
import myapplication.com.myplattvok.utils.JsonParseUtlis;

public class Detail_Activity extends AppCompatActivity {

    CollapsingToolbarLayout collapsing_toolbar;

    String name;
    String id;
    TextView textView_title,textView_id,textView_player;
    ImageView image;
    Bean bean;
    TextView url_0,url_1,url_2,url_3,url_4,url_5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        Intent intent=getIntent();
        id=intent.getStringExtra("id");
        name=intent.getStringExtra("name");
        textView_title= (TextView) findViewById(R.id.title);
        textView_id= (TextView) findViewById(R.id.id);
        textView_player= (TextView) findViewById(R.id.player);
        image= (ImageView) findViewById(R.id.image);
        url_0= (TextView) findViewById(R.id.url_0);
        url_1= (TextView) findViewById(R.id.url_1);
        url_2= (TextView) findViewById(R.id.url_2);
        url_3= (TextView) findViewById(R.id.url_3);
        url_4= (TextView) findViewById(R.id.url_4);
        url_5= (TextView) findViewById(R.id.url_5);


        x.Ext.init(getApplication());

        String url="http://www.5781000.co/av/api/get_video_data_v2/"+id;
        RequestParams requestParams=new RequestParams(url);
        requestParams.setAsJsonContent(true);
        x.http().get(requestParams,new A());
    }


    class A implements Callback.CommonCallback<String>{
        @Override
        public void onSuccess(String result) {
            try {

                System.out.println("**xiangqing"+result);
                bean= JsonParseUtlis.Jsonforbean(result);
                textView_id.setText(""+bean.getTitle());
                textView_player.setText("编号:"+bean.getId());
                textView_title.setText("演员:"+bean.getPlayer());
                url_0.setText("播放第一集");
                url_1.setText("播放第二集");
                url_2.setText("播放第三集");
                url_3.setText("播放第四集");
                url_4.setText("播放第五集");
                url_5.setText("播放第六集");
                Picasso.with(getApplicationContext()).load(bean.getPlay_conver()).resize(450, 250).centerCrop().into(image);



            } catch (Exception e) {
                e.printStackTrace();
            }




        }
        @Override
        public void onError(Throwable ex, boolean isOnCallback) {
            System.out.println("**chakan*error"+ex.toString());
        }
        @Override
        public void onCancelled(Callback.CancelledException cex) {
            System.out.println("**chakan*onCancelled");
        }
        @Override
        public void onFinished() {
            System.out.println("**chakan*onFinished");
        }
    }

    public  void click1(View v){


        String []url=bean.getPlay_list_0().split("start");
        String url1=url[0];
        Uri uri = Uri.parse(url1);
        Intent intent2 = new Intent(Intent.ACTION_VIEW);
        intent2.setDataAndType(uri, "video/mp4");
        startActivity(intent2);

    }
    public  void click0(View v){
        String []url=bean.getPlay_list_1().split("start");
        String url1=url[0];
        Uri uri = Uri.parse(url1);
        Intent intent2 = new Intent(Intent.ACTION_VIEW);
        intent2.setDataAndType(uri, "video/mp4");
        startActivity(intent2);

    }
    public  void click2(View v){
        String []url=bean.getPlay_list_2().split("start");
        String url1=url[0];
        Uri uri = Uri.parse(url1);
        Intent intent2 = new Intent(Intent.ACTION_VIEW);
        intent2.setDataAndType(uri, "video/mp4");
        startActivity(intent2);

    }
    public  void click3(View v){
        String []url=bean.getPlay_list_3().split("start");
        String url1=url[0];
        Uri uri = Uri.parse(url1);
        Intent intent2 = new Intent(Intent.ACTION_VIEW);
        intent2.setDataAndType(uri, "video/mp4");
        startActivity(intent2);

    }
    public  void click4(View v){
        String []url=bean.getPlay_list_4().split("start");
        String url1=url[0];
        Uri uri = Uri.parse(url1);
        Intent intent2 = new Intent(Intent.ACTION_VIEW);
        intent2.setDataAndType(uri, "video/mp4");
        startActivity(intent2);

    }
    public  void click5(View v){
        String []url=bean.getPlay_list_5().split("start");
        String url1=url[0];
        Uri uri = Uri.parse(url1);
        Intent intent2 = new Intent(Intent.ACTION_VIEW);
        intent2.setDataAndType(uri, "video/mp4");
        startActivity(intent2);

    }



    /**
     *
     *  http://61.222.131.65/video_data/23417/23417_1.mp4?start=0&end=120
     * http://61.222.131.65/video_data/23417/23417_3.mp4?
     * */
}
