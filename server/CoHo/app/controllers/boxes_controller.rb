class BoxesController < ApplicationController
  before_action :set_box, only: [:show, :edit, :update, :destroy]
 before_action :logged_in_user, only: [:create, :destroy]

  # GET /boxes
  # GET /boxes.json
  def index
    @boxes = current_user.boxes.all
  end

  # GET /boxes/1
  # GET /boxes/1.json
  def show
  end

  # GET /boxes/new
  def new
    @box = Box.new
    @question= Question.find(params[:question_id])
  end

  # GET /boxes/1/edit
  def edit
  end

  def boxes
     @boxes = Box.all.where(user: current_user).order("created_at DESC")
  end

  # POST /boxes
  # POST /boxes.json
  def create
    @box = current_user.boxes.build(box_params)
    @question= Question.find(params[:question_id])
    @box.user_id = current_user.id
    @box.question_id=@question.id

    respond_to do |format|
      if @box.save
        format.html { redirect_to boxes_path, notice: 'Box was successfully created.' }
        format.json { render :show, status: :created, location: @box }
      else
        format.html { render :new }
        format.json { render json: @box.errors, status: :unprocessable_entity }
      end
    end
  end

  # PATCH/PUT /boxes/1
  # PATCH/PUT /boxes/1.json
  def update
    respond_to do |format|
      if @box.update(box_params)
        format.html { redirect_to @box, notice: 'Box was successfully updated.' }
        format.json { render :show, status: :ok, location: @box }
      else
        format.html { render :edit }
        format.json { render json: @box.errors, status: :unprocessable_entity }
      end
    end
  end

  # DELETE /boxes/1
  # DELETE /boxes/1.json
  def destroy
    @box.destroy
    respond_to do |format|
      format.html { redirect_to boxes_url, notice: 'Box was successfully destroyed.' }
      format.json { head :no_content }
    end
  end

  private
    # Use callbacks to share common setup or constraints between actions.
    def set_box
      @box = Box.find(params[:id])
    end

    # Never trust parameters from the scary internet, only allow the white list through.
    def box_params
      params.require(:box).permit(:kind)
    end

end
