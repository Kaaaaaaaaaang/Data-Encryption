package MyDiary;

import java.util.ArrayList;

public class Encode {
		
	public static char alphabetBoard[][] = new char[5][5];
	public static boolean oddFlag = false; //글자수 출력
	public static String zCheck ="";
	String encryption = "";
	String decryption = "";
	char[][] table;

	public String getEncryption() {
		return encryption;
	}
	
	public void setEncryption(String encryption) {
		this.encryption = encryption;
	}
	
	public char[][] getTable() {
		return table;
	}
	
	public void setTable(char[][] table) {
		this.table = table;
	}
	
	public String getDecryption() {
		return decryption;
	}
	
	public void setDecryption(String decryption) {
		this.decryption = decryption;
	}
	
	public void Encode(String key, String content) {
		
		String blankCheck="";

		table = setBoard(key);
		setTable(table);
		
		for( int i = 0 ; i < content.length() ; i++ ) 
		{
			if(content.charAt(i)==' ') 
			{
				content = content.substring(0,i)+content.substring(i+1,content.length());
				blankCheck+=10;
			}
			else
			{
				blankCheck+=0;
			}
			if(content.charAt(i)=='z') //z를 q로 바꿔줘서 처리함.
			{
				content = content.substring(0,i)+'q'+content.substring(i+1,content.length());
				zCheck+=1;
			}
			else 
			{
				zCheck+=0;
			}
		}
		
		encryption = strEncryption(key, content);
		setEncryption(encryption);
		
		for( int i = 0 ; i < encryption.length() ; i++ ) 
		{
			if(encryption.charAt(i)==' ') //공백제거
				encryption = encryption.substring(0,i)+encryption.substring(i+1,encryption.length());
		}
		
		decryption = strDecryption(key, encryption, zCheck);
		
		for( int i = 0 ; i < decryption.length() ; i++)
		{
			if(blankCheck.charAt(i)=='1')
			{
				decryption = decryption.substring(0,i)+" "+decryption.substring(i,decryption.length());
			}
		}
		
		setDecryption(decryption);
		
		// System.out.println("복호화된 문자열 : " + decryption);
		
	}
	
	
	private static String strEncryption(String key, String str){
		ArrayList<char[]> playFair = new ArrayList<char[]>();
		ArrayList<char[]> encPlayFair = new ArrayList<char[]>();
		int x1 = 0 , x2 = 0 , y1 = 0, y2 = 0;
		String encStr ="";
		
		
		
		for( int i = 0 ; i < str.length() ; i+=2 ) // arraylist 세팅
		{
			char[] tmpArr = new char[2];
			tmpArr[0] = str.charAt(i);
			try{
				if( str.charAt(i) == str.charAt(i+1)) //글이 반복되면 x추가
				{
					tmpArr[1] = 'x';
					i--;
				}else{
					tmpArr[1] = str.charAt(i+1);
				}
			}catch(StringIndexOutOfBoundsException e)
			{
				tmpArr[1] = 'x'; 
				oddFlag = true;
			}
			playFair.add(tmpArr);
		}

		for(int i = 0 ; i < playFair.size() ; i++ )
		{

			char[] tmpArr = new char[2];
			for( int j = 0 ; j < alphabetBoard.length ; j++ ) //쌍자암호의 각각 위치체크
			{
				for( int k = 0 ; k < alphabetBoard[j].length ; k++ )
				{
					if(alphabetBoard[j][k] == playFair.get(i)[0])
					{
						x1 = j;
						y1 = k;
					}
					if(alphabetBoard[j][k] == playFair.get(i)[1])
					{
						x2 = j;
						y2 = k;
					}
				}
			}
			
			
			if(x1==x2) //행이 같은경우
			{
				tmpArr[0] = alphabetBoard[x1][(y1+1)%5];
				tmpArr[1] = alphabetBoard[x2][(y2+1)%5];
			}
			else if(y1==y2) //열이 같은 경우
			{
				tmpArr[0] = alphabetBoard[(x1+1)%5][y1];
				tmpArr[1] = alphabetBoard[(x2+1)%5][y2];
			} 
			else //행, 열 모두 다른경우
			{
				tmpArr[0] = alphabetBoard[x2][y1];
				tmpArr[1] = alphabetBoard[x1][y2];
			}
			
			encPlayFair.add(tmpArr);
			
		}
		
		for(int i = 0 ; i < encPlayFair.size() ; i++)
		{
			encStr += encPlayFair.get(i)[0]+""+encPlayFair.get(i)[1]+" ";
		}
		
		
		return encStr;
	}
	private static String strDecryption(String key, String str, String zCheck) {
		ArrayList<char[]> playFair = new ArrayList<char[]>(); //바꾸기 전 쌍자암호를 저장할 곳
		ArrayList<char[]> decPlayFair = new ArrayList<char[]>(); //바꾼 후의 쌍자암호 저장할 곳
		int x1 = 0 , x2 = 0 , y1 = 0, y2 = 0; //쌍자 암호 두 글자의 각각의 행,열 값
		String decStr ="";

		int lengthOddFlag = 1;
		
		
		for( int i = 0 ; i < str.length() ; i+=2 )
		{
			char[] tmpArr = new char[2];
			tmpArr[0] = str.charAt(i);
			tmpArr[1] = str.charAt(i+1);
			playFair.add(tmpArr);
		}
		
		
		for(int i = 0 ; i < playFair.size() ; i++ )
		{

			char[] tmpArr = new char[2];
			for( int j = 0 ; j < alphabetBoard.length ; j++ )
			{
				for( int k = 0 ; k < alphabetBoard[j].length ; k++ )
				{
					if(alphabetBoard[j][k] == playFair.get(i)[0])
					{
						x1 = j;
						y1 = k;
					}
					if(alphabetBoard[j][k] == playFair.get(i)[1])
					{
						x2 = j;
						y2 = k;
					}
				}
			}
			
			if(x1==x2) //행이 같은 경우 각각 바로 아래열 대입
			{
				tmpArr[0] = alphabetBoard[x1][(y1+4)%5];
				tmpArr[1] = alphabetBoard[x2][(y2+4)%5];
			}
			else if(y1==y2) //열이 같은 경우 각각 바로 옆 열 대입
			{
				tmpArr[0] = alphabetBoard[(x1+4)%5][y1];
				tmpArr[1] = alphabetBoard[(x2+4)%5][y2];
			}
			else //행, 열 다른경우 각자 대각선에 있는 곳.
			{
				tmpArr[0] = alphabetBoard[x2][y1];
				tmpArr[1] = alphabetBoard[x1][y2];
			}
			
			decPlayFair.add(tmpArr);
			
		}
		
		for(int i = 0 ; i < decPlayFair.size() ; i++) //중복 문자열 돌려놓음
		{
			if(i!=decPlayFair.size()-1 && decPlayFair.get(i)[1]=='x' 
					&& decPlayFair.get(i)[0]==decPlayFair.get(i+1)[0])
			{	
				decStr += decPlayFair.get(i)[0];
			}
			else
			{
				decStr += decPlayFair.get(i)[0]+""+decPlayFair.get(i)[1];
			}
		}
		
		
		
		for(int i = 0 ; i < zCheck.length() ; i++ )//z위치 찾아서 q로 돌려놓음
		{
			if( zCheck.charAt(i) == '1' ) 
				decStr = decStr.substring(0,i)+'z'+decStr.substring(i+1,decStr.length());
			
		}
		
		
		
		if(oddFlag) decStr = decStr.substring(0,decStr.length()-1);
		
		/*
		 //띄어쓰기
		for(int i = 0 ; i < decStr.length(); i++)
		{
			if(i%2==lengthOddFlag){
				decStr = decStr.substring(0, i+1)+" "+decStr.substring(i+1, decStr.length());
				i++;
				lengthOddFlag = ++lengthOddFlag %2;
			}
		}
		*/
		return decStr;
	}
	private static char[][] setBoard(String key) {
		String keyForSet = "";					// 중복된 문자가 제거된 문자열을 저장할 문자열.
		boolean duplicationFlag = false;		// 문자 중복을 체크하기 위한 flag 변수.
		int keyLengthCount = 0;					// alphabetBoard에 keyForSet을 넣기 위한 count변수.
		
		key += "abcdefghijklmnopqrstuvwxyz"; 	// 키에 모든 알파벳을 추가.

		
		// 중복처리
		for( int i = 0 ; i < key.length() ; i++ ) 
		{
			for( int j = 0 ; j < keyForSet.length() ; j++ )
			{
				if(key.charAt(i)==keyForSet.charAt(j))
				{
					duplicationFlag = true;
					break;
				}
			}
			if(!(duplicationFlag)) keyForSet += key.charAt(i);
			duplicationFlag = false;
		}
		//배열에 대입
		for( int i = 0 ; i < alphabetBoard.length ; i++ )
		{
			for( int j = 0; j <alphabetBoard[i].length ; j++ )
			{
				alphabetBoard[i][j] = keyForSet.charAt(keyLengthCount++);
			}
		}

		return alphabetBoard;
						
	}

}
