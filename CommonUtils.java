package Utils;

import cn.hutool.core.net.NetUtil;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.util.Duration;



import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;

public class CommonUtils
{
    /**
     * get the local mac address.
     * length is 48bits.
     * @param inetAddress
     * @return mac address.
     */
    public static String getLocalMac(InetAddress inetAddress) {
        try {
            //based on the internet address to get the local mac address.
            byte[] mac = NetworkInterface.getByInetAddress(inetAddress).getHardwareAddress();
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < mac.length; i++) {
                if (i != 0) {
                    sb.append("-");
                }
                //convert the byte to integer.
                int temp = mac[i] & 0xff;
                String str = Integer.toHexString(temp);
                if (str.length() == 1) {
                    sb.append("0" + str);
                } else {
                    sb.append(str);
                }
            }
            return sb.toString();
        } catch (Exception exception) {
        }
        return null;
    }

    public static String getLocalMacByHutool(InetAddress inetAddress) throws UnknownHostException
    {
        String localMacAddress = NetUtil.getMacAddress(inetAddress);
        return localMacAddress;
    }

    public static void setTime(Label labelTime)
    {
        DateFormat currentTime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        EventHandler<ActionEvent> eventHandler= e->{
            labelTime.setText(currentTime.format(new Date()));
        };
        Timeline animation = new Timeline(
                new KeyFrame(Duration.millis(1000),eventHandler));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();
    }
}
