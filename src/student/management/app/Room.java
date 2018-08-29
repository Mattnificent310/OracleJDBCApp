/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student.management.app;

/**
 *
 * @author matt.maree
 */
public class Room {
    private int roomNo;
    private int capacity;
    private String layout;
    private Hostel hostel;

    public int getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(int roomNo) {
        this.roomNo = roomNo;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getLayout() {
        return layout;
    }

    public void setLayout(String layout) {
        this.layout = layout;
    }

    public Hostel getHostel() {
        return hostel;
    }

    public void setHostel(Hostel hostel) {
        this.hostel = hostel;
    }

    public Room(int roomNo, int capacity, String layout, Hostel hostel) {
        this.roomNo = roomNo;
        this.capacity = capacity;
        this.layout = layout;
        this.hostel = hostel;
    }
    
}
