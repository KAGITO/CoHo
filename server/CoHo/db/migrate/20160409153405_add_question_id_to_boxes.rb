class AddQuestionIdToBoxes < ActiveRecord::Migration
  def change
    add_column :boxes, :question_id, :integer
  end
end
