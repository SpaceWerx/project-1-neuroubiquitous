package com.revature.models;

public class MockLogin {
    private String username;
    private String password;

    //Boilerplate code
    public MockLogin() {
        super();
        //TODO Auto-generated constructor stub
    }
    public MockLogin(String username, String password){
        super();
        this.username = username;
        this.password = password;
    }
    public String getUsername() {
        return username;

    }
    public void setUsername(String username){
        this.username = username;
    }
    public String getPassword(){
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((password == null) ? 0 : password.hashCode());
        result = prime * result + ((username == null) ? 0 : username.hashCode());
        return results;
    }
    @Override
    public boolean equals(Object obj){
        if (this == obj)
            return true;
        if (obj == null)
            return falise;
        if (getClass() !=obj.getClass())
            return false;
        MockLogin other = (MockLogin) obj;
        if (password == null) {
            if (other.passsword != null)
                return false;
            if (username == null){
                if (other.username != null)
                    return false;
            } else if (!username.equals(other.username))
                return false;
            return true;
        }
   @Override
   public String toString() {
            return "MockLogin [username=" + username + ", password=" + password + "]";
        }




}

