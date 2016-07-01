package sdfd;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ShowDiary extends JFrame implements ActionListener {

	JLabel Title = new JLabel("Title :", Label.RIGHT);
	JLabel Date = new JLabel("Date :", Label.RIGHT);

	JTextField tfTitle = new JTextField(10);
	JTextField tfDate = new JTextField(10);
	JTextField tf3 = new JTextField(20);

	JLabel Contents = new JLabel("Contents :", Label.RIGHT);
	JLabel imagePath = new JLabel("imagePath :", Label.RIGHT);

	private JFileChooser jfc = new JFileChooser();

	private JButton Open = new JButton("일기읽기");
	private JButton Save = new JButton("일기저장");
	private JButton prev = new JButton("이전날짜");
	private JButton next = new JButton("다음날짜");
	TextArea comments = new TextArea(30, 40);

	public ShowDiary() {
		super("Diary");
		this.init();
		this.setSize(350, 700);
		this.setVisible(true);
	}

	public String getCurrentDate() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.KOREA);
		Date currentTime = new Date();
		String date = formatter.format(currentTime);
		return date;
	}

	public String getDiaryDate() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd-HH-mm-ss", Locale.KOREA);
		Date currentTime = new Date();
		String date = formatter.format(currentTime);
		return date;
	}

	public void init() {
		getContentPane().setLayout(new FlowLayout());// 왼쪽에서 오른족으로 이어져나가는 레이아웃.
		String today = getCurrentDate();
		add(Title);
		add(tfTitle);
		add(Date);
		add(tfDate);
		tfDate.setText(today);
		add(Contents);
		add(comments);
		add(imagePath);
		add(tf3);
		add(prev);
		add(Open);
		add(Save);
		add(next);
		Open.addActionListener(this);
		Save.addActionListener(this);
		prev.addActionListener(this);
		next.addActionListener(this);
		jfc.setFileFilter(new FileNameExtensionFilter("txt", "txt")); // 파일 필터
		jfc.setMultiSelectionEnabled(false); // 다중 선택 불가
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == Open) {
			if (jfc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
				Title.setText("열기 경로 : " + jfc.getSelectedFile().toString());
				String filepath = jfc.getSelectedFile().toString();
				File openFile = new File(filepath);
				try {
					Scanner open = new Scanner(openFile);
					String readdata1 = open.nextLine();
					String readdata2 = open.nextLine();
					String readdata3 = open.nextLine();
					tfTitle.setText(readdata1);
					tfDate.setText(readdata2);
					comments.setText(readdata3);
					open.close();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		} else if (e.getSource() == Save) {
			if (jfc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
				Title.setText("저장 경로 : " + jfc.getCurrentDirectory().toString() + "\\Diary-" + getDiaryDate() + "."
						+ jfc.getFileFilter().getDescription());
				String filepath = jfc.getCurrentDirectory().toString() + "\\Diary-" + getDiaryDate() + "."
						+ jfc.getFileFilter().getDescription();
				File saveFile = new File(filepath);
				try {
					PrintWriter wFile = new PrintWriter(saveFile);
					String textContent1 = tfTitle.getText();
					String textContent2 = tfDate.getText();
					String textContent3 = comments.getText();
					wFile.print(textContent1);
					wFile.println(" ");
					wFile.print(textContent2);
					wFile.println(" ");
					wFile.print(textContent3);
					wFile.close();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		} else if (e.getSource() == next) {
			Title.setText("열기 경로 : " + jfc.getSelectedFile().toString());
			String directory = jfc.getCurrentDirectory().toString();
			final File folder = new File(directory);

			List<String> list = listFilesForFolder(folder);
			String nextDiary = getNextDiary(jfc.getSelectedFile().getName(), list);

			String filePath = directory + "\\" + nextDiary;
			File openFile = new File(filePath);
			try {
				Scanner open = new Scanner(openFile);
				String readdata1 = open.nextLine();
				String readdata2 = open.nextLine();
				String readdata3 = open.nextLine();
				tfTitle.setText(readdata1);
				tfDate.setText(readdata2);
				comments.setText(readdata3);
				open.close();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else if (e.getSource() == prev) {
			Title.setText("열기 경로 : " + jfc.getSelectedFile().toString());
			String directory = jfc.getCurrentDirectory().toString();
			final File folder = new File(directory);

			List<String> list = listFilesForFolder(folder);
			String nextDiary = getPrevDiary(jfc.getSelectedFile().getName(), list);

			String filePath = directory + "\\" + nextDiary;
			File openFile = new File(filePath);
			try {
				Scanner open = new Scanner(openFile);
				String readdata1 = open.nextLine();
				String readdata2 = open.nextLine();
				String readdata3 = open.nextLine();
				tfTitle.setText(readdata1);
				tfDate.setText(readdata2);
				comments.setText(readdata3);
				open.close();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	private String getPrevDiary(String name, List<String> originList) {
		double numbers[] = new double[originList.size()];

		DecimalFormat form = new DecimalFormat("###");

		// 오름차순 정렬하기 위한 날짜리스트 추출
		for (int i = 0; i < originList.size(); i++) {
			String diaryName = originList.get(i);
			diaryName = diaryName.substring(5, 23);
			diaryName = diaryName.replace("-", "");
			numbers[i] = Double.parseDouble(diaryName);
		}

		// 오름차순 정렬
		Arrays.sort(numbers);

		// 현재 다이어리 날짜추출
		name = name.substring(5, 23);
		name = name.replace("-", "");
		double date = Double.parseDouble(name);

		// 리스트에서 현재날짜와 비교해서 다음 날짜데이터 출력
		double prevDate = 0;
		for (int i = 0; i < numbers.length; i++) {
			if (date == numbers[i]) {
				if (i + 1 < numbers.length) {
					prevDate = numbers[i - 1];
				}
			}
		}

		// 다음 다이어리 제목으로 변환
		String prevDiary = "";

		if (prevDate == 0) {
			prevDiary = name;
		} else {
			prevDiary = form.format(prevDate);
		}
		prevDiary = "Diary-" + prevDiary.substring(0, 8) + "-" + prevDiary.substring(8, 10) + "-"
				+ prevDiary.substring(10, 12) + "-" + prevDiary.substring(12) + ".txt";
		return prevDiary;
	}

	private String getNextDiary(String name, List<String> originList) {

		double numbers[] = new double[originList.size()];

		DecimalFormat form = new DecimalFormat("###");

		// 오름차순 정렬하기 위한 날짜리스트 추출
		for (int i = 0; i < originList.size(); i++) {
			String diaryName = originList.get(i);
			diaryName = diaryName.substring(5, 23);
			diaryName = diaryName.replace("-", "");
			numbers[i] = Double.parseDouble(diaryName);
		}

		// 오름차순 정렬
		Arrays.sort(numbers);

		// 현재 다이어리 날짜추출
		name = name.substring(5, 23);
		name = name.replace("-", "");
		double date = Double.parseDouble(name);

		// 리스트에서 현재날짜와 비교해서 다음 날짜데이터 출력
		double nextDate = 0;
		for (int i = 0; i < numbers.length; i++) {
			if (date == numbers[i]) {
				if (i + 1 < numbers.length) {
					nextDate = numbers[i + 1];
				}
			}
		}

		// 다음 다이어리 제목으로 변환
		String nextDiary = "";

		if (nextDate == 0) {
			nextDiary = name;
		} else {
			nextDiary = form.format(nextDate);
		}
		nextDiary = "Diary-" + nextDiary.substring(0, 8) + "-" + nextDiary.substring(8, 10) + "-"
				+ nextDiary.substring(10, 12) + "-" + nextDiary.substring(12) + ".txt";
		return nextDiary;
	}

	public static List<String> listFilesForFolder(final File folder) {
		List<String> list = new ArrayList<String>();
		for (final File fileEntry : folder.listFiles()) { // 인자로 받은 파일의 리스트에서
			if (fileEntry.getName().length() > 7 && fileEntry.getName().substring(0, 5).equals("Diary")) {
				list.add(fileEntry.getName().toString());
			}
		}
		return list;
	}

}
