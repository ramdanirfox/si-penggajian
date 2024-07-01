/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package penggajian_karyawan;
/**
 *
 * @author ramdanirfox
 */
public class Penggajian_Karyawan {
    private static String userId;
    private static String userName;
    private static String nameDisplay;
    private static String userJabatan;
    private static String userGolongan;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
    public static void setUserInfo(String id, String username, String name, String jabatan, String golongan) {
        userId = id;
        userName = name;
        nameDisplay = name;
        userJabatan = jabatan;
        userGolongan = golongan;
    }
    
    public static String getUserId() {
        return userId;
    }
    
    public static String getUsername() {
        return userName;
    }
    
    public static String getDisplayName() {
        return nameDisplay;
    }
    
    public static String getJabatan() {
        return userJabatan;
    }
    
    public static String getGolongan() {
        return userGolongan;
    }
    
}
