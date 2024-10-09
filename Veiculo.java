public abstract class Veiculo {
    protected String modelo;
    protected int anoFabricacao;

    public Veiculo(String modelo, int anoFabricacao) {
        if(modelo == null || modelo.isEmpty()) {
            throw new IllegalArgumentException("Modelo é obrigatório.");
        }
        if(anoFabricacao < 1886) { // Primeiro carro foi inventado em 1886
            throw new IllegalArgumentException("Ano de fabricação inválido.");
        }
        this.modelo = modelo;
        this.anoFabricacao = anoFabricacao;
    }

    public abstract String gerarComandoInsert();
}

public class AutomovelDomestico extends Veiculo {
    private String montadora;
    private String cor;
    private int kilometragem;
    private int maxPassageiros;
    private String tipoFreio;
    private boolean airbag;

    public AutomovelDomestico(String modelo, int anoFabricacao, String montadora, String cor, int kilometragem, int maxPassageiros, String tipoFreio, boolean airbag) {
        super(modelo, anoFabricacao);
        this.montadora = montadora;
        this.cor = cor;
        this.kilometragem = kilometragem;
        this.maxPassageiros = maxPassageiros;
        this.tipoFreio = tipoFreio;
        this.airbag = airbag;
    }

    @Override
    public String gerarComandoInsert() {
        return String.format("INSERT INTO AutomovelDomestico (modelo, anoFabricacao, montadora, cor, kilometragem, maxPassageiros, tipoFreio, airbag) " +
                "VALUES ('%s', %d, '%s', '%s', %d, %d, '%s', %b);",
                modelo, anoFabricacao, montadora, cor, kilometragem, maxPassageiros, tipoFreio, airbag);
    }
}

public class Motocicleta extends Veiculo {
    private int cilindradas;
    private int torque;

    public Motocicleta(String modelo, int anoFabricacao, int cilindradas, int torque) {
        super(modelo, anoFabricacao);
        this.cilindradas = cilindradas;
        this.torque = torque;
    }

    @Override
    public String gerarComandoInsert() {
        return String.format("INSERT INTO Motocicleta (modelo, anoFabricacao, cilindradas, torque) " +
                "VALUES ('%s', %d, %d, %d);",
                modelo, anoFabricacao, cilindradas, torque);
    }
}

public class Caminhao extends Veiculo {
    private int eixos;
    private int pesoBruto;

    public Caminhao(String modelo, int anoFabricacao, int eixos, int pesoBruto) {
        super(modelo, anoFabricacao);
        this.eixos = eixos;
        this.pesoBruto = pesoBruto;
    }

    @Override
    public String gerarComandoInsert() {
        return String.format("INSERT INTO Caminhao (modelo, anoFabricacao, eixos, pesoBruto) " +
                "VALUES ('%s', %d, %d, %d);",
                modelo, anoFabricacao, eixos, pesoBruto);
    }
}

public class Bicicleta extends Veiculo {
    private String marca;
    private String cor;
    private String material;
    private int marchas;
    private boolean amortecedor;

    public Bicicleta(String modelo, int anoFabricacao, String marca, String cor, String material, int marchas, boolean amortecedor) {
        super(modelo, anoFabricacao);
        this.marca = marca;
        this.cor = cor;
        this.material = material;
        this.marchas = marchas;
        this.amortecedor = amortecedor;
    }

    @Override
    public String gerarComandoInsert() {
        return String.format("INSERT INTO Bicicleta (modelo, anoFabricacao, marca, cor, material, marchas, amortecedor) " +
                "VALUES ('%s', %d, '%s', '%s', '%s', %d, %b);",
                modelo, anoFabricacao, marca, cor, material, marchas, amortecedor);
    }
}

public class Skate extends Veiculo {
    private String marca;
    private String cor;
    private String tipoRodas;

    public Skate(String modelo, int anoFabricacao, String marca, String cor, String tipoRodas) {
        super(modelo, anoFabricacao);
        this.marca = marca;
        this.cor = cor;
        this.tipoRodas = tipoRodas;
    }

    @Override
    public String gerarComandoInsert() {
        return String.format("INSERT INTO Skate (modelo, anoFabricacao, marca, cor, tipoRodas) " +
                "VALUES ('%s', %d, '%s', '%s', '%s');",
                modelo, anoFabricacao, marca, cor, tipoRodas);
    }
}

public class TesteVeiculos {
    public static void main(String[] args) {
        AutomovelDomestico carro = new AutomovelDomestico("Civic", 2020, "Honda", "Preto", 12000, 5, "ABS", true);
        Motocicleta moto = new Motocicleta("Ninja", 2019, 650, 70);
        Caminhao caminhao = new Caminhao("Scania", 2018, 4, 16000);
        Bicicleta bike = new Bicicleta("Caloi", 2021, "Caloi", "Vermelho", "Alumínio", 21, true);
        Skate skate = new Skate("Street", 2022, "Santa Cruz", "Azul", "Poliuretano");

        System.out.println(carro.gerarComandoInsert());
        System.out.println(moto.gerarComandoInsert());
        System.out.println(caminhao.gerarComandoInsert());
        System.out.println(bike.gerarComandoInsert());
        System.out.println(skate.gerarComandoInsert());
    }
}
