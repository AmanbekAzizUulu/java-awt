package complete_reference_examples.working_with_menu; // Определение пакета

import java.awt.CheckboxMenuItem;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MenuDemo extends Frame {

	private String message = ""; 																	// Переменная для хранения сообщения

	private final MenuBar menu_bar; 																// Объявление объекта меню-бара

	private final Menu menu_file; 																	// Объявление меню File
	private final Menu menu_edit; 																	// Объявление меню Edit
	private final Menu menu_special; 																// Объявление меню Special

	private final MenuItem menuItem_new; 															// Объявление пункта меню New
	private final MenuItem menuItem_open; 															// Объявление пункта меню Open
	private final MenuItem menuItem_close; 															// Объявление пункта меню Close
	private final MenuItem menuItem_non_for_file; 													// Объявление разделителя меню
	private final MenuItem menuItem_quit; 															// Объявление пункта меню Quit

	private final MenuItem menuItem_cut; 															// Объявление пункта меню Cut
	private final MenuItem menuItem_copy; 															// Объявление пункта меню Copy
	private final MenuItem menuItem_paste;															// Объявление пункта меню Paste
	private final MenuItem menuItem_refactor; 														// Объявление пункта меню Refactor
	private final MenuItem menuItem_non_for_edit_1; 												// Объявление первого разделителя меню Edit
	private final MenuItem menuItem_non_for_edit_2; 												// Объявление второго разделителя меню Edit

	private final MenuItem menuItem_first; 															// Объявление пункта меню First
	private final MenuItem menuItem_second; 														// Объявление пункта меню Second
	private final MenuItem menuItem_third; 															// Объявление пункта меню Third

	private final CheckboxMenuItem checkboxMenuItem_debug; 											// Объявление пункта меню Debug
	private final CheckboxMenuItem checkboxMenuItem_testing; 										// Объявление пункта меню Testing

	private MenuHandler menuHandler = new MenuHandler(); 											// Создание объекта MenuHandler

	public MenuDemo(String title) {
		super(title); 																				// Вызов конструктора суперкласса с параметром title

		menu_bar = new MenuBar();																	// Инициализация меню-бара
		setMenuBar(menu_bar); 																	// Установка меню-бара для фрейма

		menu_file = new Menu("File"); 														// Инициализация меню File

		menuItem_new = new MenuItem("New"); 													// Инициализация пункта меню New
		menuItem_open = new MenuItem("Open"); 												// Инициализация пункта меню Open
		menuItem_close = new MenuItem("Close"); 												// Инициализация пункта меню Close
		menuItem_non_for_file = new MenuItem("-"); 											// Инициализация разделителя меню
		menuItem_quit = new MenuItem("Quit"); 												// Инициализация пункта меню Quit

		menuItem_new.addActionListener(menuHandler); 												// Добавление обработчика действий для пункта меню New
		menuItem_open.addActionListener(menuHandler); 											// Добавление обработчика действий для пункта меню Open
		menuItem_close.addActionListener(menuHandler); 											// Добавление обработчика действий для пункта меню Close
		menuItem_quit.addActionListener(menuHandler); 											// Добавление обработчика действий для пункта меню Quit

		menuItem_quit.addActionListener(quit_on_close -> System.exit(0)); 					// Добавление обработчика для выхода из приложения

		menu_file.add(menuItem_new); 															// Добавление пункта меню New в меню File
		menu_file.add(menuItem_open); 															// Добавление пункта меню Open в меню File
		menu_file.add(menuItem_close); 															// Добавление пункта меню Close в меню File
		menu_file.add(menuItem_non_for_file); 													// Добавление разделителя в меню File
		menu_file.add(menuItem_quit); 															// Добавление пункта меню Quit в меню File

		menu_bar.add(menu_file); 																	// Добавление меню File в меню-бар

		menu_edit = new Menu("Edit"); 														// Инициализация меню Edit

		menuItem_cut = new MenuItem("Cut"); 													// Инициализация пункта меню Cut
		menuItem_copy = new MenuItem("Copy"); 												// Инициализация пункта меню Copy
		menuItem_paste = new MenuItem("Paste"); 												// Инициализация пункта меню Paste
		menuItem_refactor = new MenuItem("Refactor"); 										// Инициализация пункта меню Refactor
		menuItem_non_for_edit_1 = new MenuItem("-"); 											// Инициализация первого разделителя меню Edit
		menuItem_non_for_edit_2 = new MenuItem("-"); 											// Инициализация второго разделителя меню Edit

		menuItem_cut.addActionListener(menuHandler); 												// Добавление обработчика действий для пункта меню Cut
		menuItem_copy.addActionListener(menuHandler); 											// Добавление обработчика действий для пункта меню Copy
		menuItem_paste.addActionListener(menuHandler); 											// Добавление обработчика действий для пункта меню Paste
		menuItem_refactor.addActionListener(menuHandler); 										// Добавление обработчика действий для пункта меню Refactor

		menu_edit.add(menuItem_cut); 															// Добавление пункта меню Cut в меню Edit
		menu_edit.add(menuItem_copy); 															// Добавление пункта меню Copy в меню Edit
		menu_edit.add(menuItem_paste); 															// Добавление пункта меню Paste в меню Edit
		menu_edit.add(menuItem_non_for_edit_1); 													// Добавление первого разделителя в меню Edit
		menu_edit.add(menuItem_refactor); 														// Добавление пункта меню Refactor в меню Edit
		menu_edit.add(menuItem_non_for_edit_2); 													// Добавление второго разделителя в меню Edit

		menu_bar.add(menu_edit); 																	// Добавление меню Edit в меню-бар

		menu_special = new Menu("Special"); 													// Инициализация меню Special

		menuItem_first = new MenuItem("First"); 												// Инициализация пункта меню First
		menuItem_second = new MenuItem("Second");												// Инициализация пункта меню Second
		menuItem_third = new MenuItem("Third"); 												// Инициализация пункта меню Third

		menuItem_first.addActionListener(menuHandler); 											// Добавление обработчика действий для пункта меню First
		menuItem_second.addActionListener(menuHandler); 											// Добавление обработчика действий для пункта меню Second
		menuItem_third.addActionListener(menuHandler); 											// Добавление обработчика действий для пункта меню Third

		menu_special.add(menuItem_first); 														// Добавление пункта меню First в меню Special
		menu_special.add(menuItem_second); 														// Добавление пункта меню Second в меню Special
		menu_special.add(menuItem_third); 														// Добавление пункта меню Third в меню Special

		menu_edit.add(menu_special); 															// Добавление меню Special в меню Edit

		checkboxMenuItem_debug = new CheckboxMenuItem("Debug"); 								// Инициализация чекбокса Debug
		checkboxMenuItem_testing = new CheckboxMenuItem("Testing"); 							// Инициализация чекбокса Testing

		checkboxMenuItem_debug.addItemListener(new MenuHandler()); 								// Добавление обработчика событий для чекбокса Debug
		checkboxMenuItem_testing.addItemListener(new MenuHandler()); 								// Добавление обработчика событий для чекбокса Testing

		menu_edit.add(checkboxMenuItem_debug); 													// Добавление чекбокса Debug в меню Edit
		menu_edit.add(checkboxMenuItem_testing); 												// Добавление чекбокса Testing в меню Edit

		addWindowListener(new WindowCloser()); 													// Добавление обработчика закрытия окна

		setFont(new Font("SansSerif", Font.BOLD, 14)); 							// Установка шрифта для фрейма
		setVisible(true);																			// Сделать фрейм видимым
		setSize(new Dimension(300, 300)); 											// Установка размеров фрейма
	}

	@Override
	public void paint(Graphics g) { 																// Переопределение метода paint для отрисовки
		g.drawString(message, 10, 220); 													// Отрисовка сообщения

		if (checkboxMenuItem_debug.getState()) { 													// Проверка состояния чекбокса Debug
			g.drawString("Debug is ON", 10, 240); 											// Отрисовка сообщения если Debug включен
		} else {
			g.drawString("Debug is OFF", 10, 240); 											// Отрисовка сообщения если Debug выключен
		}

		if (checkboxMenuItem_testing.getState()) { 													// Проверка состояния чекбокса Testing
			g.drawString("Testing is ON", 10, 260); 										// Отрисовка сообщения если Testing включен
		} else {
			g.drawString("Testing is OFF", 10, 260); 										// Отрисовка сообщения если Testing выключен
		}
	}

	private class WindowCloser extends WindowAdapter { 												// Определение внутреннего класса для обработки закрытия окна

		@Override
		public void windowClosing(WindowEvent e) { 													// Метод вызывается при закрытии окна
			System.exit(0); 																	// Завершение работы приложения
		}

	}

	private class MenuHandler implements ActionListener, ItemListener { 							// Определение внутреннего класса для обработки действи в меню

		@Override
		public void actionPerformed(ActionEvent e) { 												// Обработка событий действия
			message = "You've selected:   "; 														// Инициализация сообщения

			String action_command = e.getActionCommand(); 											// Получение команды действия

			switch (action_command) { 																// Проверка команды действия
				case "New":
					message += "New"; 																// Добавление к сообщению "New"
					break;
				case "Open":
					message += "Open"; 																// Добавление к сообщению "Open"
					break;
				case "Close":
					message += "Close"; 															// Добавление к сообщению "Close"
					break;
				case "Cut":
					message += "Cut"; 																// Добавление к сообщению "Cut"
					break;
				case "Copy":
					message += "Copy"; 																// Добавление к сообщению "Copy"
					break;
				case "Paste":
					message += "Paste"; 															// Добавление к сообщению "Paste"
					break;
				case "Refactor":
					message += "Refactor"; 															// Добавление к сообщению "Refactor"
					break;
				case "Special":
					message += "Special"; 															// Добавление к сообщению "Special"
					break;
				case "First":
					message += "First"; 															// Добавление к сообщению "First"
					break;
				case "Second":
					message += "Second";															// Добавление к сообщению "Second"
					break;
				case "Third":
					message += "Third"; 															// Добавление к сообщению "Third"
					break;
				case "Debug":
					message += "Debug"; 															// Добавление к сообщению "Debug"
					break;
				case "Testing":
					message += "Testing"; 															// Добавление к сообщению "Testing"
					break;
				default:
					System.err.println("Unsupported menu item"); 									// Сообщение об ошибке для неподдерживаемого пункта меню
					break;
			}

			repaint(); // Перерисовка фрейма
		}

		@Override
		public void itemStateChanged(ItemEvent e) { 												// Обработка изменений состояния
			repaint(); 																				// Перерисовка фрейма
		}

	}

	public static void main(String[] args) {
		new MenuDemo("Menu Demo");
	}
}
