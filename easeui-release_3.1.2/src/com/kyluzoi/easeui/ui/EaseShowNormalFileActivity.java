package com.kyluzoi.easeui.ui;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import com.hyphenate.EMCallBack;
import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMFileMessageBody;
import com.hyphenate.util.FileUtils;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ProgressBar;
import android.widget.Toast;

public class EaseShowNormalFileActivity extends EaseBaseActivity {
	private ProgressBar progressBar;
	private File file;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(com.kyluzoi.easeui.R.layout.ease_activity_show_file);
		progressBar = (ProgressBar) findViewById(com.kyluzoi.easeui.R.id.progressBar);

		final EMFileMessageBody messageBody = getIntent().getParcelableExtra("msgbody");
		file = new File(messageBody.getLocalUrl());
		//set head map
		final Map<String, String> maps = new HashMap<String, String>();
		if (!TextUtils.isEmpty(messageBody.getSecret())) {
			maps.put("share-secret", messageBody.getSecret());
		}
		
		//下载文件
		EMClient.getInstance().chatManager().downloadFile(messageBody.getRemoteUrl(), messageBody.getLocalUrl(), maps,
                new EMCallBack() {
                    
                    @Override
                    public void onSuccess() {
                        runOnUiThread(new Runnable() {
                            public void run() {
                                FileUtils.openFile(file, EaseShowNormalFileActivity.this);
                                finish();
                            }
                        });
                    }
                    
                    @Override
                    public void onProgress(final int progress,String status) {
                        runOnUiThread(new Runnable() {
                            public void run() {
                                progressBar.setProgress(progress);
                            }
                        });
                    }
                    
                    @Override
                    public void onError(int error, final String msg) {
                        runOnUiThread(new Runnable() {
                            public void run() {
                                if(file != null && file.exists()&&file.isFile())
                                    file.delete();
                                String str4 = getResources().getString(com.kyluzoi.easeui.R.string.Failed_to_download_file);
                                Toast.makeText(EaseShowNormalFileActivity.this, str4+msg, Toast.LENGTH_SHORT).show();
                                finish();
                            }
                        });
                    }
                });
		
	}
}