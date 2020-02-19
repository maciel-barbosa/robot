package br.com.myapp.robot;

import br.com.myapp.eventos.KeyCtrlV;
import br.com.myapp.eventos.KeyDelete;
import br.com.myapp.eventos.KeyDown;
import br.com.myapp.eventos.KeyEnter;
import br.com.myapp.eventos.KeyLeft;
import br.com.myapp.eventos.KeyRight;
import br.com.myapp.eventos.KeyUp;
import br.com.myapp.eventos.MouseLeft;
import br.com.myapp.eventos.MouseRight;
import br.com.myapp.eventos.Polimorfo;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Separator;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * 
 * @author 1737104 http://tutorials.jenkov.com/javafx/label.html
 *
 */

public class Main extends Application { // 1

	public ObservableList<Object> items;
	public ListView<Polimorfo> lvList;
	public int i = 0;
	public boolean continuaThread = false;

	public Main() {
		this.items = (ObservableList<Object>) FXCollections.observableArrayList();
		this.lvList = (ListView<Polimorfo>) new ListView();
	}

	public static void main(String[] args) {
		launch();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		final Scene scene = new Scene((Parent) this.sizingSample(), 500.0, 480.0);
		// scene.getStylesheets().add((Object)
		// this.getClass().getResource("application.css").toExternalForm());
		primaryStage.setTitle("MyRobot.");
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	private Pane sizingSample() {
		final BorderPane border = new BorderPane();
		border.setPadding(new Insets(20.0, 0.0, 20.0, 20.0));

		this.lvList.setItems((ObservableList) this.items);
		this.lvList.setMaxHeight(Double.NEGATIVE_INFINITY);
		this.lvList.setPrefWidth(150.0);
		border.setLeft((Node) this.lvList);

		border.setRight((Node) this.createButtonColumn());
		border.setBottom((Node) this.createButtonRow());

		// border.setTop((Node) this.createTopColumn());
		return (Pane) border;
	}

	private VBox createTopColumn() {
		final Button btnEnter = new Button("Enter");
		final GridPane grid = new GridPane();
		grid.setHgap(4.0);
		grid.setVgap(8.0);
		grid.setPadding(new Insets(4.0));
		grid.add((Node) btnEnter, 1, 0);
		final VBox vbButtons = new VBox();
		vbButtons.setSpacing(10.0);
		vbButtons.setPadding(new Insets(0.0, 20.0, 10.0, 20.0));
		vbButtons.getChildren().addAll(new Node[] { (Node) grid });
		return vbButtons;
	}

	private VBox createButtonColumn() {
		final Button btnDelete = new Button("Delete");
		final Button btnEnter = new Button("Enter");
		final Button btnUp = new Button("KeyUp");
		final Button btnLeft = new Button("KeyLeft");
		final Button btnRight = new Button("KeyRight");
		final Button btnDown = new Button("KeyDown");
		final Button btnMouseLeft = new Button("MouseLeft");
		final Button btnMouseRight = new Button("MouseRight");
		final Button btnCtrlV = new Button("Ctrl V");
		btnDelete.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		btnEnter.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		btnUp.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		btnDown.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		btnLeft.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		btnRight.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		btnMouseLeft.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		btnMouseRight.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		btnCtrlV.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		final GridPane grid = new GridPane();
		grid.setHgap(4.0);
		grid.setVgap(8.0);
		grid.setPadding(new Insets(4.0));
		grid.add((Node) btnEnter, 1, 0);
		grid.add((Node) btnDelete, 1, 1);
		grid.add((Node) new Separator(), 1, 2);
		grid.add((Node) btnUp, 1, 3);
		grid.add((Node) btnLeft, 0, 4);
		grid.add((Node) btnDown, 1, 4);
		grid.add((Node) btnRight, 2, 4);
		grid.add((Node) new Separator(), 0, 5);
		grid.add((Node) new Separator(), 1, 5);
		grid.add((Node) new Separator(), 2, 5);
		grid.add((Node) btnMouseLeft, 0, 6);
		grid.add((Node) btnMouseRight, 2, 6);
		grid.add((Node) new Separator(), 0, 7);
		grid.add((Node) new Separator(), 1, 7);
		grid.add((Node) new Separator(), 2, 7);
		grid.add((Node) btnCtrlV, 2, 8);
		final VBox vbButtons = new VBox();
		vbButtons.setSpacing(10.0);
		vbButtons.setPadding(new Insets(0.0, 20.0, 10.0, 20.0));
		vbButtons.getChildren().addAll(new Node[] { (Node) grid });
		btnDelete.setOnAction(ae -> this.items.add((Object) new KeyDelete()));
		btnEnter.setOnAction(ae -> this.items.add((Object) new KeyEnter()));
		btnUp.setOnAction(ae -> this.items.add((Object) new KeyUp()));
		btnDown.setOnAction(ae -> this.items.add((Object) new KeyDown()));
		btnLeft.setOnAction(ae -> this.items.add((Object) new KeyLeft()));
		btnRight.setOnAction(ae -> this.items.add((Object) new KeyRight()));
		btnMouseLeft.setOnAction(ae -> this.items.add((Object) new MouseLeft()));
		btnMouseRight.setOnAction(ae -> this.items.add((Object) new MouseRight()));
		btnCtrlV.setOnAction(ae -> this.items.add((Object) new KeyCtrlV()));
		return vbButtons;
	}

	@SuppressWarnings("unchecked")
	private TilePane createButtonRow() {
		final TilePane tileButtons = new TilePane(Orientation.HORIZONTAL);
		tileButtons.setPadding(new Insets(10.0, 10.0, 10.0, 0.0));
		tileButtons.setHgap(4.0);
		tileButtons.setVgap(4.0);
		final Alert alert = new Alert(Alert.AlertType.INFORMATION);
		final Button btnClear = new Button("Limpar");
		final Button btnAction = new Button("Iniciar");
		final Spinner<Integer> spinWait = (Spinner<Integer>) new Spinner(0, 10, 3, 1);
		final Spinner<Integer> spinInterval = (Spinner<Integer>) new Spinner(0, 1000, 300, 100);
		final Spinner<Integer> spinRepeat = (Spinner<Integer>) new Spinner(0, 100, 0, 1);
		final Spinner<Integer> spinWait2 = (Spinner<Integer>) new Spinner(0, 360, 0, 5);
		final TextField txtTime = new TextField();
		txtTime.setEditable(false);
		final ProgressBar progressBar = new ProgressBar(0);

		final GridPane grid = new GridPane();
		grid.setHgap(4.0);
		grid.setVgap(4.0);
		grid.setPadding(new Insets(4.0));
		grid.add((Node) spinWait, 0, 0);
		grid.add((Node) new Label("Iniciar ap\u00f3s (seg)"), 1, 0);
		grid.add((Node) spinInterval, 0, 2);
		grid.add((Node) new Label("Intervalo entre comandos (ms)"), 1, 2);
		grid.add((Node) spinRepeat, 0, 3);
		grid.add((Node) new Label("Repetir a lista (x) vezes"), 1, 3);
		grid.add((Node) spinWait2, 0, 4);
		grid.add((Node) new Label("Intervalo após repetição (seg)"), 1, 4);
		grid.add((Node) btnClear, 0, 5);
		grid.add((Node) btnAction, 1, 5);
		grid.add((Node) txtTime, 0, 6);
		grid.add((Node) progressBar, 1, 6);

		btnClear.setOnAction((EventHandler) new EventHandler<ActionEvent>() {
			public void handle(final ActionEvent event) {
				// Main.this.items.clear();
				// spinWait2.getValueFactory().setValue(0);
				Main.this.continuaThread = false;
			}
		});

		btnAction.setOnAction((EventHandler) new EventHandler<ActionEvent>() {
			public void handle(final ActionEvent event) {

				new Thread() {

					@Override
					public void run() {

						float contaPBar = spinRepeat.getValue() + 1;
						float contaInc = 1;
						float f = 1 / contaPBar;
						Main.this.continuaThread = true;

						// Aguarda x segundos para começar
						if ((int) spinWait.getValue() > 0) {
							try {
								for (int conta = 0; conta < (int) spinWait.getValue(); ++conta) {
									txtTime.setText("Iniciando em " + conta + "/" + spinWait.getValue());
									Thread.sleep(1000);
								}
							} catch (Exception e) {
								e.printStackTrace();
							}
						}

						i = 0;

						txtTime.setText("Executando a lista.");

						while (Main.this.continuaThread) {
							for (i = 0; i < (int) spinRepeat.getValue(); ++i) {

								for (int j = 0; j < Main.this.items.size(); ++j) {
									((Polimorfo) Main.this.items.get(j)).executa();
									if ((int) spinInterval.getValue() > 0) {
										try {

											Thread.sleep((int) spinInterval.getValue());
										} catch (Exception e2) {
											e2.printStackTrace();
										}
									}
								}

								txtTime.setText("Repetição da lista nº " + (i + 1));

								if (contaInc < contaPBar) {
									progressBar.setProgress(f * contaInc);
									contaInc++;
								}

								if (!Main.this.continuaThread) {
									txtTime.setText("Cancelada no nº" + (i + 1));
									break;
								}

								// A cada repetição aguarda x segundos
								if ((int) spinWait2.getValue() > 0 && i < spinRepeat.getValue()) {
									try {
										Thread.sleep((int) spinWait2.getValue() * 1000);
									} catch (Exception e) {
										e.printStackTrace();
									}
								} else {
									try {
										Thread.sleep(1000);
									} catch (Exception e) {
										e.printStackTrace();
									}
								}

								if (i == ((int) spinRepeat.getValue()) - 1) {
									Main.this.continuaThread = false;
									progressBar.setProgress(1.0);
									txtTime.setText("Processo concluído.");
								}

							}
						}

					};

				}.start();

				/*
				 * synchronized(this) { alert.setTitle("Information Dialog");
				 * alert.setHeaderText((String) null);
				 * alert.setContentText("O processo encerrado."); alert.showAndWait(); }
				 */
			}
		});

		tileButtons.getChildren().addAll(new Node[] { (Node) grid });
		return tileButtons;
	}
}