package school.sptech;

import school.sptech.especialistas.DesenvolvedorMobile;
import school.sptech.especialistas.DesenvolvedorWeb;

import java.util.ArrayList;
import java.util.List;

public class Consultoria {

    private String nome;
    private Integer vagas;
    private List<Desenvolvedor> desenvolvedores;

    public Consultoria(String nome, Integer vagas) {
        this.nome = nome;
        this.vagas = vagas;
        this.desenvolvedores = new ArrayList<>();
    }

    public Consultoria() {
    }

    public Boolean contratar(Desenvolvedor desenvolvedor){
        if (vagas > desenvolvedores.size()){
            desenvolvedores.add(desenvolvedor);
            return true;
        }
        return false;
    }

    public Boolean contratarFullstack(DesenvolvedorWeb desenvolvedor){
        if (desenvolvedor.isFullstack() == true){
            desenvolvedores.add(desenvolvedor);
            return true;
        }
        return false;
    }

    public Double getTotalSalarios(){
        Double total = 0.0;

        for (Desenvolvedor desenvolvedor : desenvolvedores){
            total += desenvolvedor.calcularSalario();
        }
        return total;
    }

    public Integer qtdDesenvolvedoresMobile(){

        Integer quantidadeDevsMobile = 0;

        for (Desenvolvedor desenvolvedor : desenvolvedores){
            if (desenvolvedor instanceof DesenvolvedorMobile) {
                quantidadeDevsMobile++;
            }
        }
        return quantidadeDevsMobile;
    }

    public List<Desenvolvedor> buscarPorSalarioMaiorIgualQue(Double salario) {
        List<Desenvolvedor> resultado = new ArrayList<>();

        for (Desenvolvedor desenvolvedor : this.desenvolvedores) {
            if (desenvolvedor.calcularSalario() >= salario) {
                resultado.add(desenvolvedor);
            }
        }
        return resultado;
    }

    public Desenvolvedor buscarMenorSalario(){
        if (desenvolvedores.isEmpty() == true){
            return null;
        }

        Desenvolvedor menorSalarioDesenvolvedor = desenvolvedores.get(0);
        for (Desenvolvedor desenvolvedor : desenvolvedores) {
            if (desenvolvedor.calcularSalario() < menorSalarioDesenvolvedor.calcularSalario()) {
                menorSalarioDesenvolvedor = desenvolvedor;
            }
        }
        return menorSalarioDesenvolvedor;
    }

    public List<Desenvolvedor> buscarPorTecnologia(String tecnologia) {
        List<Desenvolvedor> resultado = new ArrayList<>();

        for (Desenvolvedor desenvolvedor : this.desenvolvedores) {
            if (desenvolvedor instanceof DesenvolvedorWeb) {
                DesenvolvedorWeb devWeb = (DesenvolvedorWeb) desenvolvedor;
                if (devWeb.getBackend().equalsIgnoreCase(tecnologia) || devWeb.getFrontend().equalsIgnoreCase(tecnologia) || devWeb.getSgbd().equalsIgnoreCase(tecnologia)) {
                    resultado.add(devWeb);
                }
            }
            else if (desenvolvedor instanceof DesenvolvedorMobile) {
                DesenvolvedorMobile devMobile = (DesenvolvedorMobile) desenvolvedor;
                if (devMobile.getLinguagem().equalsIgnoreCase(tecnologia) || devMobile.getPlataforma().equalsIgnoreCase(tecnologia)) {
                    resultado.add(devMobile);
                }
            }
        }
        return resultado;
    }

    public Double getTotalSalariosPorTecnologia(String tecnologia) {
        Double total = 0.0;

        for (Desenvolvedor desenvolvedor : this.desenvolvedores) {
            if (desenvolvedor instanceof DesenvolvedorWeb) {
                DesenvolvedorWeb devWeb = (DesenvolvedorWeb) desenvolvedor;
                if (devWeb.getBackend().equalsIgnoreCase(tecnologia) || devWeb.getFrontend().equalsIgnoreCase(tecnologia) || devWeb.getSgbd().equalsIgnoreCase(tecnologia)) {
                    total += devWeb.calcularSalario();
                }
            } else if (desenvolvedor instanceof DesenvolvedorMobile) {
                DesenvolvedorMobile devMobile = (DesenvolvedorMobile) desenvolvedor;
                if (devMobile.getLinguagem().equalsIgnoreCase(tecnologia) || devMobile.getPlataforma().equalsIgnoreCase(tecnologia)) {
                    total += devMobile.calcularSalario();
                }
            }
        }
        return total;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getVagas() {
        return vagas;
    }

    public void setVagas(Integer vagas) {
        this.vagas = vagas;
    }

}
