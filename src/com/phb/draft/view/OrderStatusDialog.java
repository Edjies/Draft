package com.phb.draft.view;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.phb.draft.R;
/**
 * �����Զ���View��Dialog
 * @author Edjies
 * @date 2014-12-5
 */
public class OrderStatusDialog extends Dialog {
	private View contentView;
	/**��ʾί������*/
	private TextView mTvOQ;
	/**��ʾ��Ʊ����*/
	private TextView mTvSC;
	/**��ʾί��״̬*/
	private TextView mTvOSS;
	/**��ʾ�ϴθ���ʱ��*/
	private TextView mTvUT;
	private Button mBtConfirm;
	public OrderStatusDialog(Context context) {
		super(context);
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		contentView = inflater.inflate(R.layout.dialog_order_status, null);
		mTvOQ = (TextView) contentView.findViewById(R.id.tv_order_status_oq);
		mTvSC = (TextView) contentView.findViewById(R.id.tv_order_status_sc);
		mTvOSS = (TextView) contentView.findViewById(R.id.tv_order_status_oss);
		mTvUT = (TextView) contentView.findViewById(R.id.tv_order_status_ut);
		mBtConfirm = (Button) contentView.findViewById(R.id.bt_order_status_confirm);
		setContentView(contentView);
		setTitle("�µ�״̬���");
		mBtConfirm.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				dismiss();
				
			}
		});
	}
	
	public void setContent(String oq, String sc, String oss, String ut) {
		this.mTvOQ.setText(oq);
		this.mTvOSS.setText(oss);
		this.mTvSC.setText(sc);
		this.mTvUT.setText(ut);
	}

}
