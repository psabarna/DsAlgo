package grokking.mergeintervals.challenge;

import java.util.List;

/**
 * 1-3, 5-6
 *
 */
public class EmployeeFreeTime {
    static class Appointment{
        int start;
        int end;

        public Appointment(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public Appointment getEmployeeFreeTime(List<Appointment> appointments){
        int maxAppointmentTill = 0;
        Appointment available = new Appointment(1, Integer.MAX_VALUE);
        for(Appointment appointment: appointments){
            maxAppointmentTill = Math.max(maxAppointmentTill, appointment.end);

        }

        return null;
    }

    public static void main(String[] args) {

    }
}
