package controller;

import repository.MemberRepository;

import model.Member;
import model.Entry;


import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MemberController {

    private MemberRepository mr;

    public MemberController(MemberRepository newMr) {
        this.mr = newMr;
    }

    public boolean addMember(Member aMemebr) {
       return mr.addMember(aMemebr);
    }

    public boolean addEntry(Entry oneEntry) {
        return mr.addEntry(oneEntry);
    }

    public List<Entry> allEntriesForUser(int id) {

        return this.mr.getAllEntriesForUser(id);
    }
} 