package Calendar.presenter;

import Calendar.files.Service;
import Calendar.model.Day;
import Calendar.model.Diary;
import Calendar.model.Record;
import Calendar.UI.ConsoleUI;
import Calendar.UI.View;


public class Presenter {
    private Diary diary;
    private View consoleUI;

    private Service service;

    public Presenter(Service service) {
        this.service = service;
        this.service.setPresenter(this);
    }

    public View getConsoleUI() {
        return consoleUI;
    }

    public void setConsoleUI(View consoleUI) {
        this.consoleUI = consoleUI;
    }

    public void printDiary(Diary diary) {
        getConsoleUI().printDiary(diary);
    }

    /*
    добавить запись
     */
    public void addRecord() {
        diary.addRecordToDay(consoleUI.getDay(), consoleUI.getRecord(true));
    }

    /*
    получить записи по запрошенному дню
     */
    public void getDayRecords() {
        int dayNum = consoleUI.getDay();
        Day day = diary.getDayRecords(dayNum);
        consoleUI.printDay(dayNum, day);
    }

    /*
    поиск записи по событию
     */
    public void findRecord() {
        Record record = consoleUI.getRecord(false);
        String event = record.getEvent();
        String findedRecord = diary.findRecord(event);
        if (findedRecord.length() == 0) {
            findedRecord = "Событие " + event + " не найдено";
        } else {
            findedRecord = "Нашёл:\n" + findedRecord;
        }
        consoleUI.printRecord(findedRecord);
    }

    /*
    удаление записи по событию
     */
    public void delRecord() {
        Record record = consoleUI.getRecord(false);
        String event = record.getEvent();
        String delRecord;
        int count = diary.delRecord(event);
        if (count == 0) {
            delRecord = "Событие " + event + " не найдено. Удалять нечего.";
        } else {
            delRecord = "Удалено " + count + " событий.";
        }
        consoleUI.printRecord(delRecord);
    }

    /*
    сохранение Diary
     */
    public void saveDiary() {
        service.saveDiary(diary);
    }

    /*
    чтение Diary
     */
    public Diary readDiary() {
        diary = service.readDiary();
        return diary;
    }

    /*
    сообщение пользователю
     */
    public void showMessage(String message){
        consoleUI.showMessage(message);
    }

}