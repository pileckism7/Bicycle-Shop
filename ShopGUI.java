package Shop_V1;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

public class ShopGUI extends JFrame {
	private ArrayList<Item> uploadItems = new ArrayList<Item>();
	private ArrayList<Item> inventory = new ArrayList<Item>();
	private ArrayList<Item> checkout = new ArrayList<Item>();
	private ArrayList<Customer> customer = new ArrayList<Customer>();
	private ArrayList<Item> rentedItems = new ArrayList<Item>();
	private ArrayList<Item> history = new ArrayList<Item>();
	private Shop shop = new Shop();
	private RentedList rentalList = new RentedList("Rental");
	private JButton btnBike = new JButton("Bikes");
	private JButton btnHelmet = new JButton("Helmets");
	private JButton btnAccs = new JButton("Accessories");

	private JPanel northInventory = new JPanel();
	private JPanel centerInventory = new JPanel();
	private JPanel eastInventory = new JPanel();
	private JPanel inventoryPanel = new JPanel();

	private JButton barcodeButton;
	private  JPanel buttonPanel;
	//
	private JLabel gender = new JLabel("Gender");
	private JLabel description = new JLabel("Model");
	private JLabel color = new JLabel("Color");
	private JLabel type = new JLabel("Type");
	private JLabel rentCost = new JLabel("Rental Cost");
	private JLabel retailCost = new JLabel("Retail Cost");
	private JLabel bikeID = new JLabel("Barcode");
	private JLabel brandLabel = new JLabel("Brand");
	private JLabel sizeLabel = new JLabel("Size");
	private JLabel itemLabel = new JLabel("Item");
	private JLabel whatItem;
	private JOptionPane checkoutInfoPane;
	//helmet panel
	private JPanel helmetPanel = new JPanel();
	private JPanel helmetLabel = new JPanel();
	private JPanel eachHelmetLabel;
	private JScrollPane scrollPaneHelmet = new JScrollPane(helmetPanel);
	//bike panel
	private JPanel bicyclePanel = new JPanel();
	private JPanel bicycleLabel = new JPanel();
	private JPanel eachBikeLabel;
	private JScrollPane scrollPaneBicycle = new JScrollPane(bicyclePanel);
	//accessory panel
	private JPanel accessoryPanel = new JPanel();
	private JPanel accessoryLabel = new JPanel();
	private JPanel eachAccessoryLabel;
	private JScrollPane scrollPaneAccessory = new JScrollPane(accessoryPanel);
	//Checkout Panel 
	private JButton jb = new JButton();
	private JButton jb1 = new JButton();
	private JPanel labelsPanel;
	private JLabel idLabel;
	private JLabel rentLabel;
	private JLabel retailLabel;
	private JPanel checkoutPanel  = new JPanel();
	private JPanel checkoutItemInfo  = new JPanel();
	private JScrollPane checkoutScroll = new JScrollPane(checkoutItemInfo);
	private JPanel checkoutCostInfo  = new JPanel();
	private JPanel checkoutButtons  = new JPanel();
	private JPanel checkoutLabels  = new JPanel();
	public JPanel currentPanel;
	private JPanel eachCheckoutPanel = new JPanel();
	private JPanel checkoutRentInfo = new JPanel();
	private JPanel checkoutTotalInfo  = new JPanel();
	private JTextField howManyDays = new JTextField();
	private JTextField rentalTotal = new JTextField();
	private JTextField checkoutTotal = new JTextField();
	private JLabel howManyDayslbl = new JLabel ("How Many Days?");
	private JLabel rentalTotallbl = new JLabel ("Rent Total per Day:");
	private JLabel checkoutTotallbl = new JLabel ("Total:");
	private JButton checkoutPurchaseBtn;
	private JButton checkoutRentBtn;
	private JButton checkoutCancelBtn;
	private JPanel checkoutButton1 = new JPanel();
	private JPanel checkoutButton2 = new JPanel();
	private JPanel checkoutButton3 = new JPanel();
	private JPanel checkoutCalculations  = new JPanel();
	private double totalPrice;
	private double rentalPrice;
	private int rentDays =1;
	private JComboBox daysDrop = new JComboBox();

	//HISTORY
	private JPanel historyTab = new JPanel();
	private JPanel historyPanel = new JPanel();
	private JPanel historyLabel = new JPanel();
	private JPanel buttonPanelHist;
	private JLabel lblBarcode = new JLabel("Barcode");
	private JLabel lblAction = new JLabel("Action");
	private JLabel lblDate = new JLabel("Transaction Date");
	private JLabel lblReturnDate1 = new JLabel("Return Date");
	private JPanel historyItems = new JPanel();
	private JScrollPane scrollPaneHistory = new JScrollPane(historyItems);
	private JPanel eachHistoryEntry;

	private JButton histPrintBtn = new JButton("Print history");
	private JLabel filePathLbl = new JLabel("Enter output file path: ");
	private JPanel histButPnl = new JPanel();
	private JTextField fileOutPath = new JTextField(40);

	//MANAGE
	private JButton upBtn = new JButton("Upload new inventory from file");
	private JButton invBtn = new JButton("Add new items to inventory");
	private JPanel MngBtnPanel = new JPanel();
	private JTextField fileInput = new JTextField("Please input file directory here.", 20);

	private JLabel lblBrandManage = new JLabel("Model/Description");
	private JLabel lblItemManage = new JLabel("Name");
	private JLabel lblGenderManage = new JLabel("Gender");
	private JLabel lblColorManage = new JLabel("Color");
	private JLabel lblSizeManage = new JLabel("Size");
	private JLabel lblRetialCost = new JLabel("Retail");
	private JLabel lblRentalCost = new JLabel("Rental");

	private JPanel newManageItem = new JPanel();
	private JPanel eachManagementLabel;
	private JPanel manageTab = new JPanel();
	private JPanel managePanel = new JPanel();
	private JPanel manageLabel = new JPanel();
	private JScrollPane scrollPaneManage = new JScrollPane(managePanel);

	//RENT LIST
	private JPanel rentListTab = new JPanel();
	private JPanel rentListPanel = new JPanel();
	private JPanel rentListLabel = new JPanel();

	private JPanel buttonPanelRent;

	private JScrollPane scrollPaneRentList = new JScrollPane(rentListPanel);
	private JLabel lblCustomer = new JLabel("Customer");
	private JLabel lblRentDate = new JLabel("Date Rented");
	private JLabel lblReturnDate = new JLabel("Return Date");
	private JLabel lblReturn = new JLabel("Return");
	private JLabel lblitemInfo = new JLabel("Item");

	private JPanel rentItems = new JPanel();
	private JScrollPane scrollPaneRent = new JScrollPane(historyItems);
	private JPanel eachRentEntry;
	private String purchase;
	private String currentDate;
	private String returnDate;
	private JPanel customerInfo;
	private JTextField firstName;
	private JTextField lastName;
	private JTextField cellNumber;
	private JButton jbr;
	private JPanel historyInfoPanel;
	private JPanel itemInfoPanel;
	private JPanel itemCustPanel;
	private JTextArea itemInfoText;
	private JLabel itemCategoryPanel;
	private JButton histButt;
	private Item itm;




	public ShopGUI() {
		Management management = new Management();
		this.inventory =shop.getInventory().getItems();
		setupFrame();
		addComponents();
		addComponentsToHistory();
		addComponentsToManage();
		addComponentsToRentList();
		addBicyclesToPanel();
		addHelmetsToPanel();
		addAccessoriesToPanel();
		populateBicyclesPanel();
		populateHelmetsPanel();
		populateAccessoriesPanel();
		checkOutPanel();
		addListeners();
		this.setVisible(true);
	}
	//Set up frame
	private void setupFrame() {
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setTitle("ACME BIKE SHOP");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());		
	}
	//builds the window for history tab
	private void addComponentsToHistory() {
		scrollPaneHistory = new JScrollPane(historyItems);
		scrollPaneHistory.getVerticalScrollBar().setUnitIncrement(50);
		historyPanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
		historyPanel.setBackground(new Color(244, 244, 244));
		historyPanel.setLayout(new BorderLayout());

		historyItems.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
		historyItems.setLayout(new BoxLayout(historyItems, BoxLayout.Y_AXIS));
		historyItems.add(historyLabel);

		historyLabel.setLayout(new GridLayout(0, 5));
		historyLabel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
		historyLabel.setBackground(new Color(80, 230, 240));
		historyLabel.setPreferredSize(new Dimension(1000, 25));
		historyLabel.add(lblBarcode);
		historyLabel.add(lblitemInfo);
		historyLabel.add(lblAction);
		historyLabel.add(lblDate);
		historyLabel.add(lblReturnDate1);

		histButPnl.add(histPrintBtn);
		histButPnl.add(filePathLbl);
		histButPnl.add(fileOutPath);


		historyPanel.add(historyLabel, BorderLayout.NORTH);
		historyPanel.add(scrollPaneHistory, BorderLayout.CENTER);
		historyPanel.add(histButPnl, BorderLayout.SOUTH);
		historyPanel.updateUI();


	}

	//builds the window for manage tab
	private void addComponentsToManage() {
		managePanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
		managePanel.setBackground(new Color(244, 244, 244));
		managePanel.setLayout(new BorderLayout());

		manageLabel.setLayout(new GridLayout(0, 7));
		manageLabel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));

		manageLabel.setBackground(new Color(255, 255, 210));
		manageLabel.setPreferredSize(new Dimension(1000, 25));
		manageLabel.add(lblBrandManage);
		manageLabel.add(lblItemManage);
		manageLabel.add(lblGenderManage);
		manageLabel.add(lblColorManage);
		manageLabel.add(lblSizeManage);
		manageLabel.add(lblRetialCost);
		manageLabel.add(lblRentalCost);

		newManageItem.setLayout(new BoxLayout(newManageItem, BoxLayout.Y_AXIS));
		newManageItem.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));



		MngBtnPanel.add(upBtn);
		MngBtnPanel.add(fileInput);
		MngBtnPanel.add(invBtn);


		managePanel.add(manageLabel, BorderLayout.NORTH);
		managePanel.add(newManageItem, BorderLayout.CENTER);
		managePanel.add(MngBtnPanel, BorderLayout.SOUTH);
		managePanel.updateUI();
	}
	//builds the window for rental tab
	private void addComponentsToRentList() {
		scrollPaneRent = new JScrollPane(rentItems);
		scrollPaneRent.getVerticalScrollBar().setUnitIncrement(50);

		rentItems.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
		rentItems.setLayout(new BoxLayout(rentItems, BoxLayout.Y_AXIS));
		//rentItems.add(rentListLabel);

		rentListPanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
		rentListPanel.setBackground(new Color(244, 244, 244));
		rentListPanel.setLayout(new BorderLayout());

		rentListLabel.setLayout(new GridLayout(0, 4));
		rentListLabel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
		rentListLabel.setBackground(new Color(220, 210, 255));
		rentListLabel.setPreferredSize(new Dimension(1000, 25));
		rentListLabel.add(lblCustomer);
		rentListLabel.add(lblRentDate);
		rentListLabel.add(lblReturnDate);
		rentListLabel.add(lblReturn);

		rentListPanel.add(rentListLabel, BorderLayout.NORTH);
		rentListPanel.add(scrollPaneRent, BorderLayout.CENTER);
		rentListPanel.updateUI();
	}

	//add components to the frame
	private void addComponents() {
		JTabbedPane shopTab = new JTabbedPane(JTabbedPane.TOP);
		add(shopTab);
		inventoryPanel.setLayout(new BorderLayout());
		shopTab.addTab("Inventory", null, inventoryPanel, "Shop Inventory");
		inventoryPanel.add(northInventory, BorderLayout.NORTH);
		inventoryPanel.add(centerInventory, BorderLayout.CENTER);
		inventoryPanel.add(eastInventory, BorderLayout.EAST);
		centerInventory.setLayout(new BorderLayout());


		//Add the Categories to the inventory
		northInventory.add(btnBike);
		northInventory.add(btnHelmet);
		northInventory.add(btnAccs);

		//Add the Price calculations to the Inventory Tab
		rentListTab.setLayout(new BorderLayout());
		shopTab.addTab("Rent List" + "", null, rentListTab, "Rent Shop");
		rentListTab.add(scrollPaneRentList, BorderLayout.CENTER);

		manageTab.setLayout(new BorderLayout());
		shopTab.addTab("Manage" + "", null, manageTab, "Manage Shop");
		manageTab.add(scrollPaneManage, BorderLayout.CENTER);

		historyTab.setLayout(new BorderLayout());
		shopTab.addTab("History" + "", null, historyTab, "Shop History");
		historyTab.add(historyPanel, BorderLayout.CENTER);


	}
	//builds the window for  bicycles
	public void addBicyclesToPanel(){
		centerInventory.removeAll();

		scrollPaneBicycle = new JScrollPane(bicyclePanel);
		scrollPaneBicycle.getVerticalScrollBar().setUnitIncrement(50);
		centerInventory.add(scrollPaneBicycle ,BorderLayout.CENTER);
		centerInventory.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
		bicycleLabel.setLayout(new GridLayout(0,7));
		bicycleLabel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
		bicycleLabel.setBackground(Color.getHSBColor(244, 244, 244));
		bicyclePanel.setLayout(new BoxLayout(bicyclePanel, BoxLayout.Y_AXIS));
		bicyclePanel.add(bicycleLabel);
		bicycleLabel.add(bikeID);
		bicycleLabel.add(type);
		bicycleLabel.add(description);
		bicycleLabel.add(rentCost);
		bicycleLabel.add(gender);
		bicycleLabel.add(color);
		bicycleLabel.add(rentCost);
		bicycleLabel.add(retailCost);
		centerInventory.add(bicycleLabel, BorderLayout.NORTH);
		centerInventory.updateUI();

	}
	//Helps populate the bicycle panel
	public void populateBicyclesPanel(){
		for(Item item : inventory){
			if(item.getClass().getSimpleName().equals("Bicycle")){
				eachBikeLabel = new JPanel();
				eachBikeLabel.setLayout(new GridLayout(0,7));
				eachBikeLabel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
				eachBikeLabel.setSize(700, 25);
				centerInventory.add(bicycleLabel, BorderLayout.NORTH);
				barcodeButton = new JButton();
				buttonPanel = new JPanel();
				barcodeButton.setText("" +item.getBarcode());
				barcodeButton.setBackground(Color.lightGray);
				barcodeButton.setForeground(Color.BLACK);
				barcodeButton.addActionListener(new buttonAction(item)); // ACTION LISTENER FOR THE BUTTONS


				buttonPanel.add(barcodeButton);
				eachBikeLabel.add(buttonPanel);
				eachBikeLabel.add(new JLabel(item.getDescription()));
				eachBikeLabel.add(new JLabel(item.getName()));
				eachBikeLabel.add(new JLabel(item.getGender()));
				eachBikeLabel.add(new JLabel(item.getColor()));
				eachBikeLabel.add(new JLabel("$"+ item.getCost().getRentalCost()));
				eachBikeLabel.add(new JLabel("$" +item.getCost().getRetailCost()));
				bicyclePanel.add(eachBikeLabel);
				eachBikeLabel.setMaximumSize(new Dimension(1000, 40));


			}
		}
	}
	//builds the window for helmet panel
	public void addHelmetsToPanel(){
		centerInventory.removeAll();

		scrollPaneHelmet = new JScrollPane(helmetPanel);
		scrollPaneHelmet.getVerticalScrollBar().setUnitIncrement(50);
		centerInventory.add(scrollPaneHelmet ,BorderLayout.CENTER);
		centerInventory.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
		helmetLabel.setLayout(new GridLayout(0,7));
		helmetLabel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
		helmetLabel.setBackground(Color.getHSBColor(244, 244, 244));

		helmetPanel.setLayout(new BoxLayout(helmetPanel, BoxLayout.Y_AXIS));
		helmetPanel.add(helmetLabel);
		helmetLabel.add(bikeID);
		helmetLabel.add(type);
		helmetLabel.add(description);
		helmetLabel.add(rentCost);
		helmetLabel.add(gender);
		helmetLabel.add(color);
		helmetLabel.add(rentCost);
		helmetLabel.add(retailCost);
		centerInventory.add(helmetLabel, BorderLayout.NORTH);
		centerInventory.updateUI();


	}
	//helps populate the helmet panel
	public void populateHelmetsPanel(){
		for(Item item : inventory){
			if(item.getClass().getSimpleName().equals("Helmet")){
				eachHelmetLabel = new JPanel();
				eachHelmetLabel.setLayout(new GridLayout(0,7));
				eachHelmetLabel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
				eachHelmetLabel.setSize(700, 25);
				centerInventory.add(helmetLabel, BorderLayout.NORTH);

				barcodeButton = new JButton();
				buttonPanel = new JPanel();
				barcodeButton.setText("" +item.getBarcode());
				barcodeButton.setBackground(Color.lightGray);
				barcodeButton.setForeground(Color.BLACK);
				barcodeButton.addActionListener(new buttonAction(item)); // ACTION LISTENER FOR THE BUTTONS

				buttonPanel.add(barcodeButton);
				eachHelmetLabel.add(buttonPanel);

				eachHelmetLabel.add(new JLabel(item.getDescription()));
				eachHelmetLabel.add(new JLabel(item.getName()));
				eachHelmetLabel.add(new JLabel(item.getGender()));
				eachHelmetLabel.add(new JLabel(item.getColor()));
				eachHelmetLabel.add(new JLabel("$"+ item.getCost().getRentalCost()));
				eachHelmetLabel.add(new JLabel("$" +item.getCost().getRetailCost()));
				eachHelmetLabel.setMaximumSize(new Dimension(1000, 40));
				helmetPanel.add(eachHelmetLabel);
			}
		}
	}
	//builds the window for accessories panel
	public void addAccessoriesToPanel(){
		centerInventory.removeAll();

		scrollPaneAccessory = new JScrollPane(accessoryPanel);
		scrollPaneAccessory.getVerticalScrollBar().setUnitIncrement(50);
		centerInventory.add(scrollPaneAccessory ,BorderLayout.CENTER);
		centerInventory.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
		accessoryLabel.setLayout(new GridLayout(0,7));
		accessoryLabel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));

		accessoryLabel.setBackground(Color.getHSBColor(244, 244, 244));
		accessoryPanel.setLayout(new BoxLayout(accessoryPanel, BoxLayout.Y_AXIS));


		accessoryPanel.add(accessoryLabel);
		accessoryLabel.add(bikeID);
		accessoryLabel.add(brandLabel);
		accessoryLabel.add(itemLabel);
		accessoryLabel.add(gender);
		accessoryLabel.add(color);
		accessoryLabel.add(sizeLabel);
		accessoryLabel.add(retailCost);
		centerInventory.add(accessoryLabel, BorderLayout.NORTH);
		centerInventory.updateUI();

	}
	//helps populate the accessory panel
	public void populateAccessoriesPanel(){

		for(Item item : inventory){
			if(item.getClass().getSimpleName().equals("Accessory")){
				eachAccessoryLabel = new JPanel();
				eachAccessoryLabel.setLayout(new GridLayout(0,7));
				eachAccessoryLabel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
				eachAccessoryLabel.setSize(700, 25);
				centerInventory.add(accessoryLabel, BorderLayout.NORTH);

				barcodeButton = new JButton();
				buttonPanel = new JPanel();
				buttonPanel.add(barcodeButton);
				barcodeButton.setText("" +item.getBarcode());
				barcodeButton.setBackground(Color.lightGray);
				barcodeButton.setForeground(Color.BLACK);
				barcodeButton.addActionListener(new buttonAction(item)); // ACTION LISTENER FOR THE BUTTONS
				buttonPanel.add(barcodeButton);
				eachAccessoryLabel.add(buttonPanel);

				eachAccessoryLabel.add(new JLabel(item.getBrand()));
				eachAccessoryLabel.add(new JLabel(item.getName()));
				eachAccessoryLabel.add(new JLabel(item.getGender()));
				eachAccessoryLabel.add(new JLabel(item.getColor()));
				eachAccessoryLabel.add(new JLabel(item.getSize()));
				eachAccessoryLabel.add(new JLabel("$" +item.getCost().getRetailCost()));


				eachAccessoryLabel.setMaximumSize(new Dimension(1000, 40));

				accessoryPanel.add(eachAccessoryLabel);
				centerInventory.revalidate();
				centerInventory.repaint();
				centerInventory.updateUI();
			}
		}
	}

	//DYNAMIC checkoutpanel 
	public void checkOutPanel(){

		rentalTotal.setEditable(false);
		rentalTotal.setHorizontalAlignment(JTextField.CENTER);
		checkoutTotal.setHorizontalAlignment(JTextField.CENTER);
		checkoutTotal.setEditable(false);
		howManyDays.setHorizontalAlignment(JTextField.CENTER);


		checkoutCostInfo.setLayout(new GridLayout(0,2));
		checkoutRentInfo.setLayout(new GridLayout(0,1));
		checkoutItemInfo.setLayout(new BoxLayout(checkoutItemInfo, BoxLayout.Y_AXIS));
		checkoutTotalInfo.setLayout(new GridLayout(0,1));
		howManyDayslbl.setHorizontalAlignment(SwingConstants.CENTER);
		rentalTotallbl.setHorizontalAlignment(SwingConstants.CENTER);
		checkoutTotallbl.setHorizontalAlignment(SwingConstants.CENTER);
		checkoutRentInfo.add(howManyDayslbl);
		checkoutRentInfo.add(daysDrop);
		checkoutRentInfo.add(rentalTotallbl);
		checkoutRentInfo.add(rentalTotal);
		checkoutCostInfo.add(checkoutRentInfo);
		checkoutTotalInfo.add(new JPanel());
		checkoutTotalInfo.add(checkoutTotallbl);
		checkoutTotalInfo.add(checkoutTotal);
		checkoutTotalInfo.add(new JPanel());
		checkoutCostInfo.add(checkoutTotalInfo);

		checkoutButtons.setLayout(new GridLayout(0,3));
		checkoutPurchaseBtn = new JButton("Confirm Purchase");
		checkoutRentBtn = new JButton("Confirm Rent");
		checkoutCancelBtn = new JButton("Cancel");



		checkoutButton1.add(checkoutPurchaseBtn);
		checkoutButton2.add(checkoutRentBtn);
		checkoutButton3.add(checkoutCancelBtn);
		checkoutButtons.add(checkoutButton2);
		checkoutButtons.add(checkoutButton3);
		checkoutButtons.add(checkoutButton1);

		checkoutPanel.setLayout(new BorderLayout());
		checkoutLabels.setLayout(new GridLayout(0, 5));
		checkoutLabels.setBackground(new Color (255,0,90));
		checkoutLabels.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
		checkoutPanel.setLayout(new BoxLayout(checkoutPanel, BoxLayout.Y_AXIS));

		idLabel = new JLabel("Barcode");
		rentLabel = new JLabel("Rental Price");
		retailLabel = new JLabel("Retail Price");
		idLabel.setHorizontalAlignment(JLabel.CENTER);
		rentLabel.setHorizontalAlignment(JLabel.CENTER);
		retailLabel.setHorizontalAlignment(JLabel.CENTER);
		checkoutLabels.add(idLabel);
		checkoutLabels.add(new JLabel(""));
		checkoutLabels.add(rentLabel);
		checkoutLabels.add(new JLabel(""));
		checkoutLabels.add(retailLabel);


		eachCheckoutPanel = new JPanel();
		eachCheckoutPanel.setLayout(new GridLayout(0,5));
		eachCheckoutPanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
		eachCheckoutPanel.setMaximumSize(new Dimension(300, 25));

		checkoutCalculations.setLayout(new GridLayout(0,1));
		checkoutCalculations.add(checkoutCostInfo);
		checkoutCalculations.add(checkoutButtons);
		checkoutScroll.setPreferredSize(new Dimension(550,470));
		checkoutScroll.getVerticalScrollBar().setUnitIncrement(50);
		checkoutPanel.add(checkoutLabels, BorderLayout.NORTH);
		checkoutPanel.add(checkoutScroll , BorderLayout.CENTER);
		checkoutPanel.add(checkoutCalculations, BorderLayout.SOUTH);
		eastInventory.add(checkoutPanel);


	}
	//UPDATES THE HISTORY TAB with item action
	public void updateHistory(Item itm, String action, Customer cust){
			history.add(itm);
			
			itemInfoText = new JTextArea(itm.toString());
			itemInfoText.setEditable(false);
			itemCategoryPanel = new JLabel(itm.getClass().getSimpleName());
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
			LocalDate localDate = LocalDate.now();
			String currentDate = localDate.format(dtf);//2017/11/12
			String[] dateSub = currentDate.split("/");
			int rntDate = Integer.parseInt(dateSub[2]);
			rntDate += rentDays;
			String returnDate = dateSub[0] + "/" + dateSub[1] + "/" + rntDate;


			buttonPanelHist = new JPanel();
			histButt = new JButton();
			historyInfoPanel = new JPanel();
			historyInfoPanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
			historyInfoPanel.setLayout(new BoxLayout(historyInfoPanel, BoxLayout.Y_AXIS));
			itemInfoPanel = new JPanel();

			itemInfoPanel.add(itemInfoText);
			//itemInfoPanel.setPreferredSize(new Dimension(, 200));
			itemCustPanel = new JPanel();
			itemCustPanel.add(new JLabel(cust.toString()));
			historyInfoPanel.add(itemCategoryPanel);
			historyInfoPanel.add(itemCustPanel);
			historyInfoPanel.add(itemInfoPanel);
			histButt.setText(""+itm.getBarcode());
			buttonPanelHist.add(histButt);
			histButt.setBackground(Color.lightGray);
			histButt.setForeground(Color.BLACK);
			historyPanel.add(historyLabel, BorderLayout.NORTH);
			eachHistoryEntry = new JPanel();
			eachHistoryEntry.setLayout(new GridLayout(0,5));
			eachHistoryEntry.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
			eachHistoryEntry.add(buttonPanelHist);
			eachHistoryEntry.add(new JLabel(itm.getClass().getSimpleName()));
			eachHistoryEntry.add(new JLabel(action));
			eachHistoryEntry.add(new JLabel(currentDate));
			eachHistoryEntry.add(new JLabel(returnDate));
			historyItems.add(eachHistoryEntry);
			historyInfoPanel.updateUI();
			histButt.addActionListener(event -> JOptionPane.showMessageDialog(null, cust.toString()+"\n"+ itm.getClass().getSimpleName()+"\n"+itm.toString(),action,JOptionPane.PLAIN_MESSAGE));
		
		    	
		       
			eachHistoryEntry.setMaximumSize(new Dimension(2000, 40));
			checkoutItemInfo.removeAll();

			historyInfoPanel.updateUI();
			checkoutPanel.updateUI();
			historyItems.updateUI();
			revalidate();
			repaint();
			}
		
	



		private void addListeners() {
			btnBike.addActionListener(event -> addBicyclesToPanel());

			btnHelmet.addActionListener(event -> addHelmetsToPanel());

			btnAccs.addActionListener(event -> {addAccessoriesToPanel();});

			daysDrop.addActionListener(event ->  {rentDays = (int) daysDrop.getSelectedItem(); rentalTotal.setText("$" + (rentalPrice * rentDays));
			});

			upBtn.addActionListener(new uploadBtnAction());

			invBtn.addActionListener(new addNewInvListener());

			histPrintBtn.addActionListener(new printHistoryListener());

			checkoutCancelBtn.addActionListener(event -> this.dispose());
			
			
			


		}
		//adds items to the manage window upon upload
		public void populateMngWindow() {

			for(Item item: uploadItems){

				eachManagementLabel = new JPanel();
				eachManagementLabel.setLayout(new GridLayout(0,7));
				eachManagementLabel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
				eachManagementLabel.setSize(750, 25);


				eachManagementLabel.add(new JLabel(item.getDescription()));
				eachManagementLabel.add(new JLabel(item.getName()));
				eachManagementLabel.add(new JLabel(item.getGender()));
				eachManagementLabel.add(new JLabel(item.getColor()));
				eachManagementLabel.add(new JLabel(item.getSize()));
				eachManagementLabel.add(new JLabel("$" +item.getCost().getRetailCost()));
				eachManagementLabel.add(new JLabel("$" +item.getCost().getRentalCost()));


				eachManagementLabel.setMaximumSize(new Dimension(2000, 40));

				newManageItem.add(eachManagementLabel);
				newManageItem.revalidate();
				newManageItem.repaint();
				newManageItem.updateUI();
			}


		}
		
		public class buttonAction implements ActionListener{ // ACTION LISTENER FOR THE BUTTON // REMOVES AN ITEM FROM THE INVENTORY UPON CLICK

			Item item;
			boolean hasBeenPressed;
			boolean hasBeenReturned;
			Item checkedItem ;
			int index;
			Item returnedCheckedItem;
			Integer[] days = {1,2,3,4,5,6,7,8,9,10};
			public buttonAction(Item item)
			{
				this.item = item;
				this.index = inventory.indexOf(item);
				daysDrop = new JComboBox(days);
			}
			public void actionPerformed(ActionEvent e)
			{

				if(!hasBeenPressed){
					jb = (JButton) e.getSource();
					currentPanel = new JPanel();
					currentPanel =( (JPanel) jb.getParent().getParent());
					hasBeenPressed = true;
					accessoryPanel.remove(currentPanel);
					bicyclePanel.remove(currentPanel);
					helmetPanel.remove(currentPanel);
					JLabel itemRent;
					if(item.getCost().getRentalCost() == 0) {
						itemRent = new JLabel("Purchase-Only");			}
					else {
						itemRent = new JLabel("$"+item.getCost().getRentalCost());

					}
					whatItem = new JLabel(item.getClass().getSimpleName());
					JLabel itemCost = new JLabel("$"+item.getCost().getRetailCost());

					itemCost.setHorizontalAlignment(JLabel.CENTER);
					itemRent.setHorizontalAlignment(JLabel.CENTER);
					whatItem.setHorizontalAlignment(JLabel.CENTER);

					eachCheckoutPanel = new JPanel();
					eachCheckoutPanel.setLayout(new GridLayout(0,5));
					eachCheckoutPanel.setAlignmentX(CENTER_ALIGNMENT);
					eachCheckoutPanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
					eachCheckoutPanel.setSize(700, 25);

					eachCheckoutPanel.add(jb);
					eachCheckoutPanel.add(whatItem);
					eachCheckoutPanel.add(itemRent);
					eachCheckoutPanel.add(new JLabel(""));
					eachCheckoutPanel.add(itemCost);
					eachCheckoutPanel.setMaximumSize(new Dimension(550, 30));
					checkoutItemInfo.add(eachCheckoutPanel);

					totalPrice += item.getCost().getRetailCost();
					rentalPrice += item.getCost().getRentalCost();
					double totalAndTax = (totalPrice*0.07)+totalPrice;
					double totalAndTaxn = Math.round(totalAndTax);
					checkoutTotal.setText("$"+totalAndTaxn);
					rentalTotal.setText("$"+rentalPrice);
					checkoutPurchaseBtn.addActionListener(new PurchaseButton(item));
					try {
						checkoutRentBtn.addActionListener(new RentButton(item));
					} catch (ExceptionNonRentableItem e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					revalidate();
					repaint();

					checkedItem = inventory.remove(inventory.indexOf(item));
					checkout.add(item);
				}

				else{
					Object[] options = {"Remove From Cart", "Cancel"};

					int result =JOptionPane.showOptionDialog(null, item.toString(), "Item Description",
							JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE,
							null, options, null);
					if(result == JOptionPane.OK_OPTION){
	
						jb1 = (JButton) e.getSource();
						returnedCheckedItem = checkout.remove(checkout.indexOf(checkedItem));
						inventory.add(index, returnedCheckedItem);
						checkoutItemInfo.remove(jb1.getParent());



						if(item.getClass().getSimpleName().equals("Helmet")){

							eachHelmetLabel = new JPanel();
							eachHelmetLabel.setLayout(new GridLayout(0,7));
							eachHelmetLabel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));

							centerInventory.add(helmetLabel, BorderLayout.NORTH);

							barcodeButton = new JButton();
							buttonPanel = new JPanel();
							buttonPanel.add(barcodeButton);
							barcodeButton.setText("" +item.getBarcode());
							barcodeButton.setBackground(Color.lightGray);
							barcodeButton.setForeground(Color.BLACK);
							barcodeButton.addActionListener(new buttonAction(item)); // ACTION LISTENER FOR THE BUTTONS
							buttonPanel.add(barcodeButton);
							eachHelmetLabel.add(buttonPanel);

							eachHelmetLabel.add(new JLabel(item.getBrand()));
							eachHelmetLabel.add(new JLabel(item.getName()));
							eachHelmetLabel.add(new JLabel(item.getGender()));
							eachHelmetLabel.add(new JLabel(item.getColor()));
							eachHelmetLabel.add(new JLabel(item.getSize()));
							eachHelmetLabel.add(new JLabel("$" +item.getCost().getRetailCost()));


							eachHelmetLabel.setMaximumSize(new Dimension(1000, 40));

							helmetPanel.add(eachHelmetLabel);
							revalidate();
							repaint();
							centerInventory.updateUI();
							eastInventory.updateUI();

						}
						if(item.getClass().getSimpleName().equals("Accessory")){
							eachAccessoryLabel = new JPanel();
							eachAccessoryLabel.setLayout(new GridLayout(0,7));
							eachAccessoryLabel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));

							centerInventory.add(accessoryLabel, BorderLayout.NORTH);

							barcodeButton = new JButton();
							buttonPanel = new JPanel();
							buttonPanel.add(barcodeButton);
							barcodeButton.setText("" +item.getBarcode());
							barcodeButton.setBackground(Color.lightGray);
							barcodeButton.setForeground(Color.BLACK);
							barcodeButton.addActionListener(new buttonAction(item)); // ACTION LISTENER FOR THE BUTTONS
							buttonPanel.add(barcodeButton);
							eachAccessoryLabel.add(buttonPanel);

							eachAccessoryLabel.add(new JLabel(item.getBrand()));
							eachAccessoryLabel.add(new JLabel(item.getName()));
							eachAccessoryLabel.add(new JLabel(item.getGender()));
							eachAccessoryLabel.add(new JLabel(item.getColor()));
							eachAccessoryLabel.add(new JLabel(item.getSize()));
							eachAccessoryLabel.add(new JLabel("$" +item.getCost().getRetailCost()));


							eachAccessoryLabel.setMaximumSize(new Dimension(1000, 40));

							accessoryPanel.add(eachAccessoryLabel);
							centerInventory.revalidate();
							centerInventory.repaint();
							centerInventory.updateUI();

							revalidate();
							repaint();
							centerInventory.updateUI();
							eastInventory.updateUI();
						}
						if(item.getClass().getSimpleName().equals("Bicycle")){
							eachBikeLabel = new JPanel();
							eachBikeLabel.setLayout(new GridLayout(0,7));
							eachBikeLabel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));

							centerInventory.add(bicycleLabel, BorderLayout.NORTH);

							barcodeButton = new JButton();
							buttonPanel = new JPanel();
							buttonPanel.add(barcodeButton);
							barcodeButton.setText("" +item.getBarcode());
							barcodeButton.setBackground(Color.lightGray);
							barcodeButton.setForeground(Color.BLACK);
							barcodeButton.addActionListener(new buttonAction(item)); // ACTION LISTENER FOR THE BUTTONS
							buttonPanel.add(barcodeButton);
							eachBikeLabel.add(buttonPanel);

							eachBikeLabel.add(new JLabel(item.getBrand()));
							eachBikeLabel.add(new JLabel(item.getName()));
							eachBikeLabel.add(new JLabel(item.getGender()));
							eachBikeLabel.add(new JLabel(item.getColor()));
							eachBikeLabel.add(new JLabel(item.getSize()));
							eachBikeLabel.add(new JLabel("$" +item.getCost().getRetailCost()));


							eachBikeLabel.setMaximumSize(new Dimension(1000, 40));

							bicyclePanel.add(currentPanel);

							bicyclePanel.add(currentPanel);
							populateBicyclesPanel();
							revalidate();
							repaint();
							centerInventory.updateUI();
						}
						totalPrice -= item.getCost().getRetailCost();
						rentalPrice -= item.getCost().getRentalCost();
						checkoutTotal.setText("$"+totalPrice);
						rentalTotal.setText("$" + (rentalPrice * rentDays));



					}
				}

				revalidate();
				repaint();
			}

		}
		public class PurchaseButton implements ActionListener{
			Item item;


			public  PurchaseButton(Item item)
			{
				this.item = item;
			}
			@Override
			public void actionPerformed(ActionEvent p) {//rentDays
				String action = "purchase";
			


				if(!(checkout.isEmpty())){
					customerInfo = new JPanel();
					customerInfo.setLayout(new GridLayout(0,3));
					firstName = new JTextField(20);
					lastName = new JTextField(20);
					cellNumber = new JTextField(20);
					customerInfo.add(new JLabel("First Name"));
					customerInfo.add(new JLabel("Last Name"));
					customerInfo.add(new JLabel("Phone Number"));
					customerInfo.add(firstName);
					customerInfo.add(lastName);
					customerInfo.add(cellNumber);

					JOptionPane.showMessageDialog(null,
							customerInfo,
							"Customer Information",
							JOptionPane.PLAIN_MESSAGE);
					Customer cust = new Customer(firstName.getText(), lastName.getText(), cellNumber.getText());
					customer.add(cust);

					for(Item item : checkout){
						updateHistory(item, action, cust);
						rentedItems.remove(item);
					}
					checkout.clear();
					totalPrice = 0;
					rentalPrice = 0;
					checkoutTotal.setText("$0");
					rentalTotal.setText("$0");


				}


			}
		}

		public class RentButton implements ActionListener{
			Item item;
			String itemInfos = "";

			public  RentButton(Item item) throws ExceptionNonRentableItem{
				itemInfos += item.listItem();
				this.item = item;
				rentedItems.add(item);
			}

			public void actionPerformed(ActionEvent e) {

				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
				LocalDate localDate = LocalDate.now();
				String currentDate = localDate.format(dtf);//2017/11/12
				String[] dateSub = currentDate.split("/");
				int rntDate = Integer.parseInt(dateSub[2]);
				rntDate += rentDays;
				String returnDate = dateSub[0] + "/" + dateSub[1] + "/" + rntDate;

				JPanel customerInfo = new JPanel();
				customerInfo.setLayout(new GridLayout(0,3));
				JTextField firstName = new JTextField(20);
				JTextField lastName = new JTextField(20);
				JTextField cellNumber = new JTextField(20);
				customerInfo.add(new JLabel("First Name"));
				customerInfo.add(new JLabel("Last Name"));
				customerInfo.add(new JLabel("Phone Number"));
				customerInfo.add(firstName);
				customerInfo.add(lastName);
				customerInfo.add(cellNumber);





				if(!(checkout.isEmpty())){
					JOptionPane.showMessageDialog(null, customerInfo);
					//	if(firstName.getText() == null || lastName.getText() == null || )
					Customer cust = new Customer(firstName.getText(), lastName.getText(), cellNumber.getText());
					customer.add(cust);
					rentalList.addToList(cust, rentedItems);
					String action = "Rented";
					for(Item item : rentedItems){
						//if(item.getCost().getRentalCost() == 0) {
						//throw new ExceptionNonRentableItem(item.getClass().getSimpleName());
						//}
						updateHistory(item,action, cust);
						JButton rentButt = new JButton("Name: " +cust.getFirstName()+" "+ cust.getLastName());
						JButton returnButton = new JButton("Return Items");
						//returnButton.addActionListener(new ReturnButton(rentedItems));
						rentButt.setBackground(Color.LIGHT_GRAY);
						rentButt.setForeground(Color.BLACK);
						rentButt.addActionListener(event -> JOptionPane.showMessageDialog(null,
								item.listItem(),
								"Item Information",
								JOptionPane.PLAIN_MESSAGE));

						returnButton.setBackground(Color.lightGray);
						returnButton.setForeground(Color.BLACK);
						returnButton.addActionListener(new ReturnButton(item, cust));

						rentListPanel.add(rentListLabel, BorderLayout.NORTH);
						eachRentEntry = new JPanel();
						eachRentEntry.setLayout(new GridLayout(0,4));
						eachRentEntry.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
						eachRentEntry.add(rentButt);
						eachRentEntry.add(new JLabel(currentDate));
						eachRentEntry.add(new JLabel(returnDate));
						eachRentEntry.add(returnButton);
						rentItems.add(eachRentEntry);
						eachRentEntry.setMaximumSize(new Dimension(2000, 30));

						rentListPanel.updateUI();
						rentItems.updateUI();
						revalidate();
						repaint();
						checkout.clear();


					}
					rentedItems.clear();
				}
				customer.clear();
				totalPrice = 0;
				rentalPrice = 0;
				checkoutTotal.setText("$0");
				rentalTotal.setText("$0");

			}
		}




		public class ReturnButton implements ActionListener{
			Item item;
			Customer cust;
			public ReturnButton(Item item, Customer cust){
				this.item = item;
				this.cust = cust;
			}
			public void actionPerformed(ActionEvent e){
				jbr = (JButton) e.getSource();
				rentItems.remove(jbr.getParent());
				String action = "Returned";

				if(item.getClass().getSimpleName().equals("Helmet")){

					eachHelmetLabel = new JPanel();
					eachHelmetLabel.setLayout(new GridLayout(0,7));
					eachHelmetLabel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
					centerInventory.add(helmetLabel, BorderLayout.NORTH);

					barcodeButton = new JButton();
					buttonPanel = new JPanel();
					buttonPanel.add(barcodeButton);
					barcodeButton.setText("" +item.getBarcode());
					barcodeButton.setBackground(Color.lightGray);
					barcodeButton.setForeground(Color.BLACK);
					barcodeButton.addActionListener(new buttonAction(item)); // ACTION LISTENER FOR THE BUTTONS
					buttonPanel.add(barcodeButton);
					eachHelmetLabel.add(buttonPanel);

					eachHelmetLabel.add(new JLabel(item.getDescription()));
					eachHelmetLabel.add(new JLabel(item.getName()));
					eachHelmetLabel.add(new JLabel(item.getGender()));
					eachHelmetLabel.add(new JLabel(item.getColor()));
					eachHelmetLabel.add(new JLabel("$" +item.getCost().getRentalCost()));
					eachHelmetLabel.add(new JLabel("$" +item.getCost().getRetailCost()));


					eachHelmetLabel.setMaximumSize(new Dimension(1000, 40));

					helmetPanel.add(eachHelmetLabel);
					centerInventory.revalidate();
					centerInventory.repaint();
					centerInventory.updateUI();
					eachHelmetLabel.updateUI();
					helmetPanel.updateUI();
					revalidate();
					repaint();
					centerInventory.updateUI();
					eastInventory.updateUI();
					inventory.add(item);

				}
				if(item.getClass().getSimpleName().equals("Accessory")){
					eachAccessoryLabel = new JPanel();
					eachAccessoryLabel.setLayout(new GridLayout(0,7));
					eachAccessoryLabel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
					centerInventory.add(accessoryLabel, BorderLayout.NORTH);

					barcodeButton = new JButton();
					buttonPanel = new JPanel();
					buttonPanel.add(barcodeButton);
					barcodeButton.setText("" +item.getBarcode());
					barcodeButton.setBackground(Color.lightGray);
					barcodeButton.setForeground(Color.BLACK);
					barcodeButton.addActionListener(new buttonAction(item)); // ACTION LISTENER FOR THE BUTTONS
					buttonPanel.add(barcodeButton);
					eachAccessoryLabel.add(buttonPanel);

					eachAccessoryLabel.add(new JLabel(item.getBrand()));
					eachAccessoryLabel.add(new JLabel(item.getName()));
					eachAccessoryLabel.add(new JLabel(item.getGender()));
					eachAccessoryLabel.add(new JLabel(item.getColor()));
					eachAccessoryLabel.add(new JLabel(item.getSize()));
					eachAccessoryLabel.add(new JLabel("$" +item.getCost().getRetailCost()));


					eachAccessoryLabel.setMaximumSize(new Dimension(1000, 40));

					accessoryPanel.add(eachAccessoryLabel);
					centerInventory.revalidate();
					centerInventory.repaint();
					centerInventory.updateUI();
					eachAccessoryLabel.updateUI();
					accessoryPanel.updateUI();
					revalidate();
					repaint();
					centerInventory.updateUI();
					eastInventory.updateUI();
					inventory.add(item);
				}
				if(item.getClass().getSimpleName().equals("Bicycle")){
					eachBikeLabel = new JPanel();
					eachBikeLabel.setLayout(new GridLayout(0,7));
					eachBikeLabel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
					centerInventory.add(bicycleLabel, BorderLayout.NORTH);

					barcodeButton = new JButton();
					buttonPanel = new JPanel();
					buttonPanel.add(barcodeButton);
					barcodeButton.setText("" +item.getBarcode());
					barcodeButton.setBackground(Color.lightGray);
					barcodeButton.setForeground(Color.BLACK);
					barcodeButton.addActionListener(new buttonAction(item)); // ACTION LISTENER FOR THE BUTTONS
					buttonPanel.add(barcodeButton);
					eachBikeLabel.add(buttonPanel);

					eachBikeLabel.add(new JLabel(item.getDescription()));
					eachBikeLabel.add(new JLabel(item.getName()));
					eachBikeLabel.add(new JLabel(item.getGender()));
					eachBikeLabel.add(new JLabel(item.getColor()));
					eachBikeLabel.add(new JLabel("$" +item.getCost().getRentalCost()));
					eachBikeLabel.add(new JLabel("$" +item.getCost().getRetailCost()));


					eachBikeLabel.setMaximumSize(new Dimension(1000, 40));

					bicyclePanel.add(eachBikeLabel);
					centerInventory.revalidate();
					centerInventory.repaint();
					centerInventory.updateUI();
					eachBikeLabel.updateUI();
					bicyclePanel.updateUI();
					revalidate();
					repaint();
					centerInventory.updateUI();
					eastInventory.updateUI();
					inventory.add(item);
				}
				updateHistory(item,action, cust);
				rentedItems.remove(item);

				rentListPanel.updateUI();
				rentItems.updateUI();
				revalidate();
				repaint();
				checkout.clear();
			}
		}



		public class uploadBtnAction implements ActionListener{
			public void actionPerformed(ActionEvent e){
				try {
					uploadItems = Management.getNewItems(fileInput.getText());
				} catch (IncorrectFileException e1) {	
					e1.showMessage();;
				}
				populateMngWindow();
			}

		}

		public class addNewInvListener implements ActionListener{
			public void actionPerformed(ActionEvent e){
				for(int i = 0; i < uploadItems.size();i++){
					inventory.add(uploadItems.get(i));
				}
				populateBicyclesPanel();

				populateHelmetsPanel();

				populateAccessoriesPanel();
				centerInventory.revalidate();
				centerInventory.repaint();
				centerInventory.updateUI();
			}


		}

		public class printHistoryListener implements ActionListener{
			public void actionPerformed(ActionEvent e){
				String fileOut = fileOutPath.getText();
				OutputStream output = null;
				try {
					output = new FileOutputStream(fileOut);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				PrintStream printOut = new PrintStream(output);  
				System.setOut(printOut);
				for(int i = 0; i < history.size(); i++){
					System.out.println(history.get(i).listItem());
				}

				printOut.flush();
				printOut.close();

			}

		}


		//Prints the managed items
		public void printMngItems(){
			for(Item item: uploadItems){
				System.out.println(item.toString());
			}
		}	

		public static void main(String[] args) {
			new ShopGUI();
		}


	}



