package Translation.US_Countries;

import java.util.HashMap;

public class PT_BR_Translation {

    // ############Brazil############

    public String ptbrTranslations(String text) {
        String value = "";
        String matchingvalue = "";

        HashMap<String, String> map = new HashMap<>();
        map.put("£0.00", "$0.00");
        map.put("No Longer Available", "Já não é fabricado");
        map.put("Not Currently Stocked", "Já não existe em estoque");
        map.put("Suggested Alternatives", "Substitutos sugeridos");
        map.put("Exact Alternative", "Alternativa exata");
        map.put("Are you tax exempt? You must Sign-in or Register to place your order tax exempt.", "Você é isento de taxas? Faça login ou cadastre-se para fazer seu pedido sem impostos.");
        map.put("Tax Exempt can be applied within the checkout at Order Review step.", "A Isenção de Impostos pode aplicar-se ao finalizar a encomenda, no passo de Revisão da Encomenda");
        map.put("Tax Exempt", "Isenção de Impostos");
        map.put("Apply Tax Exempt for this order", "Aplique a Isenção de Impostos para esta encomenda");
        map.put("You must have a Tax Exemption certificate on file with the Tax Department in order to be Tax Exempt for this order.", "Tem de ter um certificado de Isenção de Impostos do Departamento de Finanças para poder ter Isenção de Impostos nesta encomenda.");
        map.put("Note: If Tax Exempt status is set for your account, it can't be changed for an individual order. If you think the tax exempt status of your order or account is incorrect, please contact us at 1-800-463-9275.", "Nota: se o status Isento de impostos estiver definido para sua conta, ele não poderá ser alterado para uma compra individual. Se você achar que o status Isento de impostos de seu pedido ou conta estiver incorreto, entre em contato conosco pelo telefone: 1-800-463-9275.");
        map.put("Tax exempt status is verified and Tax was removed from your order.", "O estatuto de isenção de impostos foi verificado e o Imposto foi removido da sua encomenda.");
        map.put("Tax exempt status is not verified yet.", "O estatuto de isenção de impostos ainda não foi verificado.");
        map.put("We will verify your Tax Exempt status within 7 days and if applicable, you get a refund. The status will be saved for later purchases.", "Vamos verificar o seu estatuto de Isenção de Impostos num prazo de 7 dias e, caso se aplique, receberá um reembolso. O estatuto será salvo para compras posteriores.");
        
        // DO NOT TOUCH BELOW CODE
        try {
            matchingvalue = map.get(text.trim());
        } catch (Exception e) {}
        if (matchingvalue == null) {
            value = text.trim();
        } else {
            value = matchingvalue.trim();
        }

        System.out.println("Value of_" + text + "_in_MEXICO=" + value);

        return (value);
    }
}
