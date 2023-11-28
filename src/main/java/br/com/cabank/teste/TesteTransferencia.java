package br.com.cabank.teste;

import br.com.cabank.bean.Transferencia;
import br.com.cabank.dao.impl.OracleTransferenciaDAO;

import java.util.Calendar;
import java.util.List;

public class TesteTransferencia {

    public static void main(String[] args){
        OracleTransferenciaDAO dao = new OracleTransferenciaDAO();

        Transferencia transferencia = new Transferencia(
                1,
                "Compra na Shopee",
                Calendar.getInstance(),
                229.99,
                "despesa",
                5234,
                2
        );

        dao.insert(transferencia);
        System.out.println("Registrado!");

        Transferencia transferencia2 = new Transferencia(
                2,
                "Pagamento recebido da irmã",
                Calendar.getInstance(),
                500.0,
                "receita",
                5234,
                3
        );

        dao.insert(transferencia2);
        System.out.println("Registrado!");

        Transferencia transferencia3 = new Transferencia(
                3,
                "Compras mercado",
                Calendar.getInstance(),
                700,
                "despesa",
                5234,
                54444
        );

        dao.insert(transferencia3);
        System.out.println("Registrado!");

        Transferencia transferencia4 = new Transferencia(
                4,
                "Posto de Gasolina",
                Calendar.getInstance(),
                100,
                "despesa",
                5234,
                2
        );

        dao.insert(transferencia4);
        System.out.println("Registrado!");

        Transferencia transferencia5 = new Transferencia(
                5,
                "Compras livraria",
                Calendar.getInstance(),
                250,
                "despesa",
                5234,
                2
        );

        dao.insert(transferencia5);
        System.out.println("Registrado!");


        List<Transferencia> todasastransferencias = dao.getAll();

        for (Transferencia item : todasastransferencias){
            System.out.println("Codigo da transferencia: " + item.getCodigoTransferencia() +
                    " Nome da transferencia : " + item.getNomeTransferencia() +
                    " Data da transferencia: " + item.getDataTransferencia().getTime().toString() +
                    " Valor da transferencia: " + item.getValorTransferencia() +
                    " Tipo de transferencia: " + item.getTipoTransferencia() +
                    " Codigo da conta: " + item.getCodigoConta() +
                    " Codigo da imagem: " + item.getCodigoImagem());
        }
    }
}
