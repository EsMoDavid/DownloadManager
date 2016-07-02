package org.aisen.downloader.utils;

import org.aisen.downloader.DownloadController;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by wangdan on 16/6/15.
 */
public class Utils {

    public static String generateMD5(String key) {
        try {
            MessageDigest e = MessageDigest.getInstance("MD5");
            e.update(key.getBytes());
            byte[] bytes = e.digest();
            StringBuilder sb = new StringBuilder();

            for(int i = 0; i < bytes.length; ++i) {
                String hex = Integer.toHexString(255 & bytes[i]);
                if(hex.length() == 1) {
                    sb.append('0');
                }

                sb.append(hex);
            }

            return sb.toString();
        } catch (NoSuchAlgorithmException var6) {
            return String.valueOf(key.hashCode());
        }
    }

    public static boolean compareStatus(DownloadController.DownloadStatus oldStatus, DownloadController.DownloadStatus newStatus) {
        if (oldStatus == null) {
            return true;
        }
        else if (newStatus == null) {
            return true;
        }
        else if (oldStatus.status != newStatus.status) {
            return true;
        }
        else if (oldStatus.progress != newStatus.progress) {
            return true;
        }
        else if (oldStatus.deleted != newStatus.deleted) {
            return true;
        }

        return false;
    }

}
