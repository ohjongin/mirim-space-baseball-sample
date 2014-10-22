package com.example.minsbaseballgame;

import java.util.Arrays;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class STAGE2 extends Activity {
	private static final int DIALOG_NEW_YES_NO = 1;

	TextView tvResult;
	TextView TextViewValue[] = new TextView[4];
	int com_Array[] = new int[4];
	int resut_arr[] = new int[4];
	int play_cnt, inputPos;
	boolean isPlay;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_stage2);

		TextViewValue[0] = (TextView) findViewById(R.id.TextViewValue1);
		TextViewValue[1] = (TextView) findViewById(R.id.TextViewValue2);
		TextViewValue[2] = (TextView) findViewById(R.id.TextViewValue3);
		TextViewValue[3] = (TextView) findViewById(R.id.TextViewValue4);
		tvResult = (TextView) findViewById(R.id.TextViewAttack2);

		// �ʱ�ȭ
		init_com();

	}

	// <- �齺���̽� ��ư�� Ŭ���Ǿ����� ȣ��Ǵ� �޼���
	public void clickBtnDelListener(View target) {

		/*
		 * for(int i=3;i>=0;i--){
		 * if(TextViewValue[i].getText().toString().trim().length()==1){
		 * TextViewValue[i].setText(" "); break; } }
		 */

		/*
		 * if(TextViewValue[3].getText().toString().trim().length()==1{
		 * TextViewValue[3].setText(" "); }else
		 * if(TextViewValue[2].getText().toString().trim().length()==1){
		 * TextViewValue[2].setText(" "); }else
		 * if(TextViewValue[1].getText().toString().trim().length()==1){
		 * TextViewValue[1].setText(" "); }else
		 * if(TextViewValue[0].getText().toString().trim().length()==1){
		 * TextViewValue[0].setText(" "); }
		 */

		if (inputPos > 0) {
			if (TextViewValue[--inputPos].getText().toString().trim().length() == 1) {
				TextViewValue[inputPos].setText(" ");
			}
		}
	}

	// ���� ��ư�� Ŭ���Ǿ����� ȣ��Ǵ� �޼���
	public void clickBtnNumListener(View target) {

		Button btnNum = ((Button) target);
		String strNum = btnNum.getText().toString();

		/*
		 * for (TextView v : TextViewValue) { if
		 * (v.getText().toString().trim().equals(strNum)) { return; } }
		 */

		// TextViewValue[0].setText(strNum);

		/*
		 * if (TextViewValue[0].getText().toString().trim().length() != 1) {
		 * TextViewValue[0].setText(strNum); } else if
		 * (TextViewValue[1].getText().toString().trim().length() != 1) {
		 * TextViewValue[1].setText(strNum); } else if
		 * (TextViewValue[2].getText().toString().trim().length() != 1) {
		 * TextViewValue[2].setText(strNum); } else if
		 * (TextViewValue[3].getText().toString().trim().length() != 1) {
		 * TextViewValue[3].setText(strNum);
		 * Toast.makeText(getApplicationContext(), "���ݹ�ư�� �����ּ���",
		 * Toast.LENGTH_SHORT).show(); }
		 */

		if (isPlay) {
			if (inputPos < 4) {

				for (TextView v : TextViewValue) {
					if (v.getText().toString().trim().equals(strNum)) {
						return;
					}
				}
				TextViewValue[inputPos].setText(strNum);
				inputPos++;

			} else {
				Toast.makeText(getApplicationContext(), "���ݹ�ư�� �����ּ���",
						Toast.LENGTH_SHORT).show();
			}
		} else {
			Toast.makeText(getApplicationContext(), "������ ���� �������ּ���!",
					Toast.LENGTH_SHORT).show();
		}

	}

	// ������ ��ư�� Ŭ���Ǿ����� ȣ��Ǵ� �޼���
	public void clickBtnNewListener(View target) {
		init_com();
	}

	// ���� �ʱ�ȭ
	public void init_com() {

		play_cnt = 0; // ����Ƚ�� �ʱ�ȭ;
		for (TextView v : TextViewValue) {
			v.setText(" ");
		}
		// �ߺ����� �ʴ� 4���� ���� ����.
		int i = 0;
		do {
			// int r = (int)(Math.random()*9)+1;
			int r = (int) (Math.random() * 10);
			com_Array[i] = r;

			for (int j = 0; j < i; j++) { // �ߺ��Ǵ� �� �˻�.
				if (com_Array[i] == com_Array[j]) {
					i--; // �ߺ����� ������ i������ -1.
					break; // �ݺ��� ����
				}// if
			}// for

			i++;

		} while (i < 4); // 4ȸ��

		// ������ �ִ� ����� Ŭ����
		tvResult.setText("");
		// tvResult.append(Arrays.toString(com_Array));
		tvResult.append("\n");
		tvResult.setText("�� ������ �����մϴ�.\n");
		tvResult.append("������ ���� 4���� �����Ͻð� [����] ��ư�� �����ּ���!\n");
		inputPos = 0;
		play_cnt = 0;
		isPlay = true;

	}

	// ���ݹ�ư�� �������� ȣ��Ǵ� �޼���
	public void attack(View target) {

		resut_arr = new int[4]; // ��� �ʱ�ȭ

		if (isPlay) {
			// �Է°� üũ (�Է¹��� ���ڰ� 4���� �ƴϸ� �޽���â ���)
			if (inputPos != 4) {
				Toast.makeText(getApplicationContext(), "������ ���� 4���� �������ּ���!",
						Toast.LENGTH_SHORT).show();
				return;
			}

			int user_Array[] = new int[4];
			for (int i = 0; i < TextViewValue.length; i++) {
				user_Array[i] = Integer.parseInt(TextViewValue[i].getText()
						.toString());
			}

			// ��� �˻�
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {

					if (com_Array[i] == user_Array[j]) {
						if (i == j) { // ���� ���� ���ڰ� �ְ� �� ������ �ڸ��� ������ ��Ʈ����ũ ó��
							resut_arr[0]++; // ��Ʈ����ũ
						} else { // ���� ���� ���ڰ� �ְ� �� ������ �ڸ��� �ٸ��� �� ó��
							resut_arr[1]++; // ��
						}// if
					}// if
				}// for
			}// for

			// �ƿ� ���
			resut_arr[3] = 4 - (resut_arr[0] + resut_arr[1]+resut_arr[2]); // �ƿ�!

			// �Է°��� ǥ���ϴ� �ؽ�Ʈ�ʵ� �ʱ�ȭ
			for (TextView v : TextViewValue) {
				v.setText(" ");
			}
			inputPos = 0;

			play_cnt++;// �÷��� ī��Ʈ ����

			// ����� ���
			String strResult = play_cnt + "ȸ��: " + Arrays.toString(user_Array)
					+ "  " + resut_arr[0] + " Strike!!   " + resut_arr[1]
					+ " Ball!!   " + resut_arr[3] + " Out!!\n";

			// tvResult.append(strResult);
			appendResult(strResult);

			if (resut_arr[0] == 4) {

				/*
				 * Toast.makeText(getApplicationContext(), "You Win!!",
				 * Toast.LENGTH_SHORT).show();
				 */
				// tvResult.append("You Win!!\n\n");

				appendResult("You Win!!\n\n");
				isPlay = false;
				dialogNewGame("You Win!!").show();

			}// if

			if (play_cnt == 9) { // �Ѱ�⿡ 9ȸ������
				/*
				 * Toast.makeText(getApplicationContext(), "You Lose!!",
				 * Toast.LENGTH_SHORT).show();
				 */
				// tvResult.append("You Lose!!\n\n");
				// showDialog(DIALOG_NEW_YES_NO);

				appendResult("You Lose!!\n\n");
				isPlay = false;
				dialogNewGame("You Lose!!").show();

			}// if

			// ScrollView result_scrollView = (ScrollView)
			// findViewById(R.id.result_scrollView);
			// result_scrollView.scrollTo(0, tvResult.getHeight());

		} else {
			Toast.makeText(getApplicationContext(), "������ ���� �������ּ���!",
					Toast.LENGTH_SHORT).show();
		}// if

	}// attack();

	// ��� �信 ��� ���
	public void appendResult(String str) {
		tvResult.append(str);
		ScrollView result_scrollView = (ScrollView) findViewById(R.id.result_scrollView);
		result_scrollView.scrollTo(0, tvResult.getHeight());
	}

	// ��ȭ���� ����
	public Dialog dialogNewGame(String result) {

		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("���")
				.setMessage(result + "\n������ ���� �����Ͻðڽ��ϱ�?")
				.setCancelable(false)
				.setPositiveButton("��", new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						init_com();

					}

				})
				.setNegativeButton("�ƴϿ�",
						new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								ScrollView result_scrollView = (ScrollView) findViewById(R.id.result_scrollView);
								result_scrollView.scrollTo(0,
										tvResult.getHeight());
								dialog.cancel();
							}

						});

		AlertDialog alert = builder.create();

		return alert;
	}

}
