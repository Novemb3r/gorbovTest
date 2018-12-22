package GUI.Forms;

public final class Constants {

    public static final String LOGIN_FORM = "login";

    public static final String REGISTER_FORM = "register";

    public static final String MENU_FORM = "mainMenu";

    public static final String TEST_STAGE = "test";

    public static final String STATS_FORM = "stats";

    public static final String[] COLUMN_NAMES = new String[]{
            "id",
            "Время прохождения первой части",
            "Время прохождения второй части",
            "Разница",
            "Ошибки на первой стадии",
            "Ошибки на второй стадии"
    };

    public static final String RULES_FORM = "rules";

    public static final String RULES_FORM_2 = "rules_2";

    public static final String RULES_TEXT_1 = "<html><h2 style=\"text-align:center\"><span style=\"font-size:24px\">Правила прохождения теста</span></h2>\n" +
            "\n" + "<br><br><br>" + "<p style=\"text-align:center\"><span style=\"font-size:24px\">Таблица №1</span></p>" + "<br><br>" +
            "<p style=\"text-align:center\"><span style=\"font-size:20px\">Перед вами таблица, содержащая 25 красных и 24 черных нумерованных квадратов. Необходимо последовательно указать сначала черные в порядке возрастания, а затем красные в порядке убывания.</span></p>\n" +
            "\n" + "<br><br><br>" +
            "<p style=\"text-align:center\"><span style=\"font-size:26px\"><em>Желаем удачи!</em></span></p></html>";

    public static final String RULES_TEXT_2 = "<html><h2 style=\"text-align:center\"><span style=\"font-size:24px\">Правила прохождения теста</span></h2>\n" +
            "\n" + "<br><br><br>" + "<p style=\"text-align:center\"><span style=\"font-size:24px\">Таблица №2</span></p>" + "<br><br>" +
            "<p style=\"text-align:center\"><span style=\"font-size:20px\">Перед вами таблица, содержащая 25 красных и 24 черных нумерованных квадратов. Необходимо попеременно указывать красные числа в порядке убывания и черные числа в порядке возрастания.</span></p>\n" +
            "\n" + "<br><br><br>" +
            "<p style=\"text-align:center\"><span style=\"font-size:26px\"><em>Желаем удачи!</em></span></p></html>";

    public static final String RESULT_FORM = "result";
}
