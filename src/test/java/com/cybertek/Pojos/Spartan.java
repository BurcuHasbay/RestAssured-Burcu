package com.cybertek.Pojos;




/*
{
   "id": 15
   "name": "Meta",
   "gender": "Female"
   "phone": 1938695106
 */
public class Spartan {

private String name;

    private String gender;

    private long phone;
    private int id;

    //GETTER SETTER
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Spartan{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", phone=" + phone +
                ", id=" + id +
                '}';
    }




}
