package repository;

import java.io.BufferedReader;

import model.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import exceptions.InvalidBudgetException;
import exceptions.InvalidNameException;
import exceptions.InvalidTypeException;

public class MemberRepository {
    private List<Member> members = new ArrayList<Member>();
    private List<Entry> entries = new ArrayList<Entry>();

    private final static String filenameMember = "membersF.txt";
    private final static String filenameBudget = "budgetF.txt";

    @SuppressWarnings("resource")
    public MemberRepository() {
        readMembers();
        readEntries();

    }

    public boolean addMember(Member m) {

        if (m.getId() < Integer.MAX_VALUE && m.getId() > 0 && !m.getName().equals("") && m.getIncome() != 0) {
            BufferedWriter out = null;
            try {
                out = new BufferedWriter(new FileWriter("membersF.txt", true));
            } catch (IOException e) {
                e.printStackTrace();
            }
            int k = 1;
            for (Member member : members) {
                if (member.getId() == m.getId()) {
                    k = 0;
                }
            }
            if (k == 1) {
                try {
                    out.newLine();
                    out.write(m.getName() + ";" + m.getId() + ";" + m.getIncome());
                    members.add(m);
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            } else {
                System.err.println("This code already exists");
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return false;
            }
        }else{
            return false;
        }


        return true;

    }

    public boolean addEntry(Entry e) {


        if (e.getIdMember() < Integer.MAX_VALUE && e.getValue() > 0 && (e.getType().equals("income") || e.getType().equals("cost"))) {
            BufferedWriter out = null;
            try {
                out = new BufferedWriter(new FileWriter("budgetF.txt", true));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            try {
                out.newLine();
                out.write(e.getType() + " " + e.getValue() + " " + e.getIdMember());
                entries.add(e);
                out.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }


        } else {
            return false;
        }


        return true;

    }

    public List<Entry> getAllEntriesForUser(int id) {
        List<Entry> list = new ArrayList<Entry>();
        for(Entry e: entries){
            if(e.getIdMember() == id){
                list.add(e);
            }
        }
        if(list.size() >0){
            return list;
        }
        return null;
    }


    public void readMembers() {
        try {
            FileReader fileReader = null;
            BufferedReader bufferedReader = null;
            String currentLine = null;

            fileReader = new FileReader(filenameMember);
            bufferedReader = new BufferedReader(fileReader);

            while ((currentLine = bufferedReader.readLine()) != null) {
                String line[] = currentLine.split(";");
                Member m = new Member(line[0], Integer.parseInt(line[1]), Integer.parseInt(line[2]));
                this.members.add(m);
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }

    }

    public void readEntries() {
        try {
            FileReader fileReaderEntry = null;
            BufferedReader bufferedReaderEntry = null;
            String currentLineEntry = null;

            fileReaderEntry = new FileReader(filenameBudget);
            bufferedReaderEntry = new BufferedReader(fileReaderEntry);

            while ((currentLineEntry = bufferedReaderEntry.readLine()) != null) {
                String line[] = currentLineEntry.split(";");
                int valueEntry = Integer.parseInt(line[1]);
                int idEntryMember = Integer.parseInt(line[2]);
                Entry e = new Entry(line[0], valueEntry, idEntryMember);
                this.entries.add(e);
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }
}
