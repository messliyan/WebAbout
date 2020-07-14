package webSocket;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * ServerManager ��ά����һ���̰߳�ȫ�ļ���servers, 
 * ������Ϊ������������������������BitCoinServer
 * broadCast ��������������ϣ���ÿ��Server�����������Ϣ��
 **/
public class ServerManager {

	//�̰߳�ȫCollections.synchronizedCollection
	private static Collection<BitCoinServer> servers = Collections.synchronizedCollection(new ArrayList<BitCoinServer>());
	
	public static void broadCast(String msg){
		for (BitCoinServer bitCoinServer : servers) {
			try {
				bitCoinServer.sendMessage(msg);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static int getTotal(){
		return servers.size();
	}
	public static void add(BitCoinServer server){
		System.out.println("�������Ӽ��룡 ��ǰ���������ǣ�"+ servers.size());
		servers.add(server);
	}
	public static void remove(BitCoinServer server){
		System.out.println("�������˳��� ��ǰ���������ǣ�"+ servers.size());
		servers.remove(server);
	}
	
}